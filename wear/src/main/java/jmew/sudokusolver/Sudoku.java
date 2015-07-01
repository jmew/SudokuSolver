package jmew.sudokusolver;

/**
 * Created by Mew on 2015-06-21.
 */
public class Sudoku {
    public static boolean SolveSudoku(int sudokuSolved[][]) {
        for (int currRow = 0; currRow < 9; currRow++) {
            for (int currCol= 0; currCol < 9; currCol++) {
                if (emptyCellCheck(sudokuSolved, currRow, currCol)) {
                    for (int num = 1; num <= 9; num++) {
                        if (numCheck(sudokuSolved, num, currRow, currCol)){
                            sudokuSolved[currRow][currCol] = num;

                            if (SolveSudoku(sudokuSolved)){
                                return true;
                            }

                            sudokuSolved[currRow][currCol] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean emptyCellCheck(int sudokuSolved[][], int row, int col) {
        if (sudokuSolved[row][col] == 0) {
            return true;
        }
        return false;
    }

    public static boolean numCheck(int sudokuSolved[][], int num, int row, int col) {
        for (int tempCol = 0; tempCol < 9; tempCol++) { //Check the entire row
            if (sudokuSolved[row][tempCol] == num) {
                return false;
            }
        }
        for (int tempRow = 0; tempRow < 9; tempRow++) { //Check the entire column
            if (sudokuSolved[tempRow][col] == num) {
                return false;
            }
        }
        switch(subSquareCheck(row, col)) {
            case 1:
                for (int tempCol = 0; tempCol < 3; tempCol++) {
                    for (int tempRow = 0; tempRow < 3; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 2:
                for (int tempCol = 3; tempCol < 6; tempCol++) {
                    for (int tempRow = 0; tempRow < 3; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 3:
                for (int tempCol = 6; tempCol < 9; tempCol++) {
                    for (int tempRow = 0; tempRow < 3; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 4:
                for (int tempCol = 0; tempCol < 3; tempCol++) {
                    for (int tempRow = 3; tempRow < 6; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 5:
                for (int tempCol = 3; tempCol < 6; tempCol++) {
                    for (int tempRow = 3; tempRow < 6; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 6:
                for (int tempCol = 6; tempCol < 9; tempCol++) {
                    for (int tempRow = 3; tempRow < 6; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 7:
                for (int tempCol = 0; tempCol < 3; tempCol++) {
                    for (int tempRow = 6; tempRow < 9; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 8:
                for (int tempCol = 3; tempCol < 6; tempCol++) {
                    for (int tempRow = 6; tempRow < 9; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
            case 9:
                for (int tempCol = 6; tempCol < 9; tempCol++) {
                    for (int tempRow = 6; tempRow < 9; tempRow++) {
                        if (sudokuSolved[tempRow][tempCol] == num) {
                            return false;
                        }
                    }
                }
                break;
        }
        return true;
    }

    public static int subSquareCheck(int row, int col) {
        int subSquare = 0;
        if (row <= 2) {
            if (col <= 2) {
                subSquare = 1;
            }
            else if (col >= 3 && col <= 5) {
                subSquare = 2;
            }
            else if (col >= 6 && col <= 8) {
                subSquare = 3;
            }
        }

        else if (row >= 2 && row <= 5) {
            if (col <= 2) {
                subSquare = 4;
            }
            else if (col >= 3 && col <= 5) {
                subSquare = 5;
            }
            else if (col >= 6 && col <= 8) {
                subSquare = 6;
            }
        }

        else if (row >= 6 && row <= 8) {
            if (col <= 2) {
                subSquare = 7;
            }
            else if (col >= 3 && col <= 5) {
                subSquare = 8;
            }
            else if (col >= 6 && col <= 8) {
                subSquare = 9;
            }
        }
        return subSquare;
    }
}