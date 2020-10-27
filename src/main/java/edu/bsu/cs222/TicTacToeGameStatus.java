package edu.bsu.cs222;

import java.util.ArrayList;

public class TicTacToeGameStatus {
    public int[] cells = new int[9];
    private int[] row1 = new int[3];
    public int[] row2 = new int[3];
    private int[] row3 = new int[3];
    private int[] col1 = new int[3];
    public int[] col2 = new int[3];
    private int[] col3 = new int[3];
    public int[] diag1 = new int[3];
    private int[] diag2 = new int[3];
    final ArrayList<int[]> blocks = new ArrayList<>();

    TicTacToeGameStatus(){
        updateBlocks();
    }
    private void updateBlocks(){
        blocks.clear();
        blocks.add(row1);
        blocks.add(row2);
        blocks.add(row3);
        blocks.add(col1);
        blocks.add(col2);
        blocks.add(col3);
        blocks.add(diag1);
        blocks.add(diag2);
    }
    void resetGameGrid(){
        cells = new int[9];
        row1 = new int[3];
        row2 = new int[3];
        row3 = new int[3];
        col1 = new int[3];
        col2 = new int[3];
        col3 = new int[3];
        diag1 = new int[3];
        diag2 = new int[3];
        updateBlocks();
    }
    void addMove(int cell, int player){
        if(cells[cell] == 0) {
            cells[cell] = player;
            addMoveToColumn(cell,player);
            addMoveToRow(cell,player);
            addMoveToDiagonal(cell,player);
            updateBlocks();
        }
    }
    private void addMoveToRow(int cell, int player){
        if(cell <= 2){
            row1[cell] = player;
        }
        else if(cell <= 5){
            row2[cell - 3] = player;
        }
        else if(cell <= 8){
            row3[cell - 6] = player;
        }
    }
    private void addMoveToColumn(int cell, int player){
        if(cell % 3 == 0){
            col1[cell / 3] = player;
        }
        else if(cell % 3 == 1){
            col2[cell / 3] = player;
        }
        else if(cell % 3 == 2){
            col3[cell / 3] = player;
        }
    }
    private void addMoveToDiagonal(int cell, int player){
        if(cell == 0){
            diag1[0] = player;
        }
        if(cell == 2){
            diag2[0] = player;
        }
        if(cell == 4){
            diag1[1] = player;
            diag2[1] = player;
        }
        if(cell == 6){
            diag2[2] = player;
        }
        if(cell == 8){
            diag1[2] = player;
        }
    }
    int checkBoard(){
        if (checkHorizontals() !=0){
            return checkHorizontals();
        }
        if(checkVerticals() !=0){
            return checkVerticals();
        }
        if(checkDiagonals() !=0){
            return checkDiagonals();
        }
        return 0;
    }

    private int checkDiagonals() {
        if(checkThreeInARow(diag1[0], diag1[1], diag1[2]) !=0){
            return row1[0];
        }

        if(checkThreeInARow(diag2[0],diag2[1],diag2[2])!=0){
            return row1[2];
        }
        return 0;
    }



    private int checkVerticals() {
        if(checkThreeInARow(row1[0], row2[0], row3[0]) != 0){
            return row1[0];
        }

        if(checkThreeInARow(row1[1], row2[1], row3[1]) != 0){
            return row1[1];
        }

        if(checkThreeInARow(row1[2], row2[2], row3[2]) != 0){
            return row1[2];
        }
        return 0;
    }

    private int checkHorizontals() {
        if(checkThreeInARow(row1[0],row1[1],row1[2]) !=0){
            return row1[0];
        }
        if (checkThreeInARow(row2[0],row2[1],row2[2])!=0){
            return row2[0];
        }
        if (checkThreeInARow(row3[0],row3[1],row3[2])!=0){
            return row3[0];
        }
        return 0;
    }
    private int checkThreeInARow(int i, int i1, int i2) {
        if(cellIsEmpty(i)){
            return 0;
        }
        else if (i==i1 && i1 == i2){
            return i;
        }
        return 0;
    }

    private boolean cellIsEmpty(int i) {
        return (i == 0);
    }
    ArrayList<Integer> findOpenCells(){
        ArrayList<Integer> openCells = new ArrayList<>();
        for (int cellToBeFilled= 0; cellToBeFilled < 9; cellToBeFilled++){
            if (cells[cellToBeFilled] == 0){
                openCells.add(cellToBeFilled);
            }
        }
        return openCells;
    }
}
