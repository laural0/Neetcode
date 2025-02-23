package ValidSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    private record Square(int row, int column) {
    }

    public boolean isValidSudoku(char[][] board) {

        Map<Square, HashSet<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    Square square = new Square(i / 3, j / 3);
                    boolean wasPresentInRow = !row.add(board[i][j]);
                    HashSet<Character> elementsFromSquare = squares.computeIfAbsent(square, square1 -> new HashSet<>());
                    boolean wasPresentInSquare = !elementsFromSquare.add(board[i][j]);
                    if(wasPresentInRow || wasPresentInSquare)
                        return false;
                }
                if (board[j][i] != '.') {
                    boolean wasPresentInColumn = !column.add(board[j][i]);
                    if(wasPresentInColumn)
                        return false;
                }
            }
        }

        return true;

    }

}
