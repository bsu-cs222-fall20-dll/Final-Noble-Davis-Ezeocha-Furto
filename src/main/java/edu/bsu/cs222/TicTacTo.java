package edu.bsu.cs222;

import java.util.ArrayList;

public class TicTacTo {

    public final TicTacToeGameStatus gameStatus = new TicTacToeGameStatus();
    public String winner = null;

    public void playerturn(int cell){
        gameStatus.addMove(cell, 1);
        checkVictory();
    }
    int computerTurn(){
        ArrayList<int[]> blocks = gameStatus.blocks;
        int blocksIndex = -1;
        int cellIndex = -1;
        int chosenBlock = -1;
        int chosenCell = -1;
        for (int i = 0; i < blocks.size(); i++){
            if (findCellToBeMarked(blocks.get(i)) != -1){
                if(findCellTobeMarked() > 2){
                    chosenBlock = i;
                    chosenCell = findCellToBeMarked(blocks.get(i)) - 3;
                }
                else {
                    blocksIndex = i;
                    cellIndex = findCellToBeMarked(blocks.get(i));
                }
            }
        }
        if(chosenCell != -1){
            int cell = findCellIndexFromBlockIndex(chosenBlock,chosenCell);
            gameStatus.addMove(cell,2);
            checkVictory();
            return cell;
        }
        else if(chosenBlock == -1){
            if(gameStatus.cells[4]==0 && Math.floor(Math.random() * 2) == 0){
                return 4;
            }
            return -1;
        }
        else {
            int cell = findCellIndexFromBlockIndex(blocksIndex,cellIndex);
            gameStatus.addMove(cell,2);
            checkVictory();
            return cell;
        }
    }

    private int findCellTobeMarked() {
        return 0;
    }

    private int findCellToBeMarked(int[] block){
        int totalXCells = 0;
        int totalOCells = 0;
        for (int i = 0; i < 3; i++){
            if(block[i]== 2){
                totalOCells++;
            }
            if(block[i] == 1){
                totalXCells++;
            }
            if(totalOCells == 2 && totalXCells == 0){
                if (findEmptyCell(block) != -1){
                    return findEmptyCell(block) + 3;
                }
            }
            if (totalXCells == 2 && totalOCells == 0){
                return findEmptyCell(block);
            }
        }
        return -1;
    }

    private int findEmptyCell(int[] block) {
        for (int i = 0; i < block.length; i++){
            int cellValue = block[i];
            if (cellValue == 0){
                return i;
            }
        }
        return -1;
    }

    private int findCellIndexFromBlockIndex(int blockIndex, int cellIndex){
        switch (blockIndex){
            case 0:
                return extractRow1(cellIndex);
            case 1:
                return extractRow2(cellIndex);
            case 2:
                return extractRow3(cellIndex);
            case 3:
                return exractCol1(cellIndex);
            case 4:
                return extractCol2(cellIndex);
            case 5:
                return extractCol3(cellIndex);
            case 6:
                return extractDia1(cellIndex);
        }
        return blockIndex;
    }

    private int extractRow1(int cellIndex) {
        return cellIndex;
    }
    private int extractRow2(int cellIndex) {
        return cellIndex;
    }
    private int extractRow3(int cellIndex){
        return cellIndex;
    }

    private int exractCol1(int cellIndex) {
        return cellIndex;
    }

    private int extractCol2(int cellIndex) {
        return cellIndex;
    }

    private int extractCol3(int cellIndex) {
        return cellIndex;
    }

    private int extractDia1(int cellIndex) {
        return cellIndex;
    }


    private void checkVictory(){
        if(gameStatus.checkBoard() != 0){
            declareWinner(gameStatus.checkBoard());
        }
    }
    private void declareWinner(int winner){
        if(winner == 1){
            this.winner = "Player";
        }
        else if(winner == 2){
            this.winner = "Computer";
        }
    }
}
