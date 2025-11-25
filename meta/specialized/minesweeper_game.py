"""
Generate a Minesweeper game board and handle reveals.
"""

import random


def generate_minesweeper_board(rows, cols, num_mines):
    # initialize all cells to 0
    board = [[0 for _ in range(cols)] for _ in range(rows)]

    # randomly place mines
    positions = random.sample(range(rows * cols), num_mines)
    for pos in positions:
        r, c = divmod(pos, cols)
        board[r][c] = -1   # -1 = mine

    # directions for 8 neighbors
    directions = [(-1, -1), (-1, 0), (-1, 1),
                  ( 0, -1),          ( 0, 1),
                  ( 1, -1), ( 1, 0), ( 1, 1)]

    # fill in counts for non-mine cells
    for r in range(rows):
        for c in range(cols):
            if board[r][c] == -1:
                continue

            count = 0
            # check all 8 neighbors
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] == -1:
                    count += 1

            board[r][c] = count

    return board


def reveal_cell(board, revealed, row, col):
    rows, cols = len(board), len(board[0])

    # out of bounds
    if not (0 <= row < rows and 0 <= col < cols):
        return

    # already revealed
    if revealed[row][col]:
        return

    # reveal this cell
    revealed[row][col] = True

    # if it's a mine, stop here (game-over handled elsewhere)
    if board[row][col] == -1:
        return

    # if it's a number > 0, just reveal it (no expansion)
    if board[row][col] > 0:
        return

    # if it's 0, reveal all neighbors recursively
    directions = [(-1, -1), (-1, 0), (-1, 1),
                  ( 0, -1),          ( 0, 1),
                  ( 1, -1), ( 1, 0), ( 1, 1)]

    for dr, dc in directions:
        reveal_cell(board, revealed, row + dr, col + dc)