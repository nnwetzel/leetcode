"""
Print the last N lines from a large file.
"""

import os

def tail_large_file(filename, n, block_size=4096):
    """
    Print the last n lines from a large file by reading from the end in blocks.
    """
    with open(filename, "rb") as f:
        # start at end of file
        f.seek(0, os.SEEK_END)
        file_size = f.tell()

        buffer = b""
        lines = []

        # read blocks from the end until we have at least n lines
        while len(lines) <= n and file_size > 0:
            read_size = min(block_size, file_size)
            file_size -= read_size

            # move back one block and read it
            f.seek(file_size)
            chunk = f.read(read_size)

            # prepend this chunk to what we've already read
            buffer = chunk + buffer

            # split into lines
            lines = buffer.splitlines()

        # print last n lines as text
        for line in lines[-n:]:
            print(line.decode("utf-8", errors="replace"))