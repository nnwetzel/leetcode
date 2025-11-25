"""
Count Battleships (formatted problem statement)

You're given an m x n board where each cell is either a battleship 'X' or empty '.'.
Battleships are placed only horizontally or vertically (each is 1 x k or k x 1).
There is at least one empty cell separating any two battleships (no adjacent ships).

Return the number of battleships on the board.
"""

from typing import List

class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        
        rows = len(board)
        cols = len(board[0])
        count = 0

        # iterate through each cell in the board
        for r in range(rows):
            for c in range(cols):
                # only count battleships
                if board[r][c] != 'X':
                    continue
                # skip if there's an 'X' above or to the left (part of an existing ship)
                if r > 0 and board[r - 1][c] == 'X':
                    continue
                if c > 0 and board[r][c - 1] == 'X':
                    continue
                count += 1
        return count