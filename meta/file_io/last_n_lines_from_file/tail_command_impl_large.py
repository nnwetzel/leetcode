"""
Print the last N lines from a large file.
"""

import os

# Time: O(N) - in worst case, read entire file
# Space: O(N) - storing last n lines
def tail_large_file(filename, n, block_size=4096):
    """
    Print the last n lines from a large file by reading from the end in blocks.
    """
    with open(filename, "rb") as f:
        # start at end of file
        f.seek(0, os.SEEK_END)
        # get current file size
        file_size = f.tell()

        # create a buffer to hold the current block of lines
        buffer = b""
        lines = []

        # read blocks from the end until we have at least n lines
        while len(lines) <= n and file_size > 0:
            # determine how much to read
            read_size = min(block_size, file_size)
            # update remaining file size
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