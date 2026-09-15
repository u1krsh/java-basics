package BackTracking;

import static BackTracking.NQueens.printB;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0 , 4);
    }

    static void knight(boolean[][] borad, int row, int col, int knigts){
        if(knigts == 0 ){
            printB(borad);
            System.out.println();
            return;
        }
        if(row == borad.length - 1 && col == borad.length){
            return;
        }
        if(col == borad.length){
            knight(borad, row +1, 0, knigts);
            return;
        }

        if(isSafe(borad, row,col)){
            borad[row][col] = true;
            knight(borad, row, col+1, knigts-1);
            borad[row][col] = false;

        }

        knight(borad,row,col+1, knigts);
    }

    private static boolean isSafe(boolean[][] borad, int row, int col) {
        if(isValid(borad,row-2,col-1)){
            if(borad[row-2][col-1]){
                return false;
            }
        }
        if(isValid(borad,row-1,col-2)){
            if(borad[row-1][col-2]){
                return false;
            }
        }
        if(isValid(borad,row-2,col+1)){
            if(borad[row-2][col+1]){
                return false;
            }
        }
        if(isValid(borad,row-1,col+2)){
            if(borad[row-1][col+2]){
                return false;
            }
        }

        return true;

    }

    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0  && row <=board.length && col >= 0 && col< board.length){
            return true;
        }
        return false;
    }
}
