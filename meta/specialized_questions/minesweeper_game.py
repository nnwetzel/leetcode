"""
Generate a Minesweeper game board and handle reveals.
"""

import random

def generate_minesweeper_board(rows, cols, num_mines):
    # initialize all cells to 0
    board = [[0 for _ in range(cols)] for _ in range(rows)]

    # randomly choose num_mines unique positions on the board, flattened into 1D
    positions = random.sample(range(rows * cols), num_mines)
    for pos in positions:
        # convert the 1D index 'pos' into a (r, c) pair where:
        #   row = pos // col -> which row the position falls into
        #   col = pos % col -> which col the position falls into
        r, c = divmod(pos, cols)
        board[r][c] = -1  # -1 represents a mine

    # directions for 8 neighbors
    directions = [(-1, -1), (-1, 0), (-1, 1),
                  ( 0, -1),          ( 0, 1),
                  ( 1, -1), ( 1, 0), ( 1, 1)]

    # fill in counts for non-mine cells
    for r in range(rows):
        for c in range(cols):
            if board[r][c] == -1:
                continue
            # count adjacent mines
            count = 0
            for dr, dc in directions:
                # calculate the position for each neighbor
                nr, nc = r + dr, c + dc
                # check if not out of bounds and is a mine
                if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] == -1:
                    # increment count for each adjacent mine
                    count += 1
            # set the count in the cell
            board[r][c] = count

    return board

def reveal_cell(board, revealed, row, col):
    rows, cols = len(board), len(board[0])

    # if out of bounds, stop here
    if not (0 <= row < rows and 0 <= col < cols):
        return

    # if already revealed, stop here
    if revealed[row][col]:
        return

    # safe to reveal this cell
    revealed[row][col] = True

    # if it's a mine, stop here (usually game over)
    if board[row][col] == -1:
        return

    # if it's a number > 0, just reveal it (no expansion)
    if board[row][col] > 0:
        return

    # if it's 0, reveal all connected zero-cells plus the numbered cells that border them
    directions = [(-1, -1), (-1, 0), (-1, 1),
                  ( 0, -1),          ( 0, 1),
                  ( 1, -1), ( 1, 0), ( 1, 1)]
    for dr, dc in directions:
        # reveal neighboring cells recursively
        reveal_cell(board, revealed, row + dr, col + dc)