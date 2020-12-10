package edu.bsu.cs222;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MinesweeperGameStatus {


    int[] cells = new int[81];
    boolean[] bombCells = new boolean[81];
    boolean[] shownCells = new boolean[81];
    public boolean[] flaggedCells = new boolean[81];

    void reset(){
        cells = new int[81];
        bombCells = new boolean[81];
        shownCells = new boolean[81];
        flaggedCells = new boolean[81];
    }

    void revealCell(int index){
        shownCells[index] = true;
    }
    public void  flagCell(int index){
        flaggedCells[index] = true;
    }
    void unflagCell(int index){
        flaggedCells[index] = true;
    }
    public void makeNewBoard(int bombId) {
        addBombs(bombId);
    }
    private void addBombs(int bombID){
        for (int i = 0; i < bombID ; i++){
            cells[i] = -1;
        }
        randomizeBoard();
        placeNumber();
        findBombs();
    }

    private void randomizeBoard() {
        Random random = ThreadLocalRandom.current();
        for (int i = cells.length - 1; i > 0; i--){
            int randomIndex = random.nextInt(i + 1);
            int randomCell = cells[randomIndex];
            cells[randomIndex] = cells[i];
            cells[i] = randomCell;
        }
    }

    private void placeNumber() {
        for (int i = 0; i < cells.length; i++){
            int cell = cells[i];
            int bombCount = 0;
            if(cell != -1){
                if (i == 0){//top left
                    if (cells[i +1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 9] == -1){
                        bombCount++;
                    }
                    if(cells[i + 10] == -1){
                        bombCount++;
                    }
                }else if (i < 8){//top middle
                    if(cells[i - 1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 8] == -1){
                        bombCount++;
                    }
                    if(cells[i + 9] == -1){
                        bombCount++;
                    }
                    if(cells[i + 10] == -1){
                        bombCount++;
                    }
                }else if(i == 8){ //top right
                    if(cells[i - 1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 8] == -1){
                        bombCount++;
                    }
                    if(cells[i + 9] == -1){
                        bombCount++;
                    }
                }
                else if(i == 72){ // bottom left
                    if(cells[i - 9] == -1){
                        bombCount++;
                    }
                    if(cells[i - 8] == -1){
                        bombCount++;
                    }
                    if(cells[i + 1] == -1){
                        bombCount++;
                    }
                }
                else if(i > 72 && i < 80){ // bottom middle
                    if(cells[i - 10] == -1){
                        bombCount++;
                    }
                    if(cells[i - 9] == -1){
                        bombCount++;
                    }
                    if(cells[i - 8] == -1){
                        bombCount++;
                    }
                    if(cells[i - 1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 1] == -1){
                        bombCount++;
                    }
                }
                else if(i == 80){ // bottom left
                    if(cells[i - 10] == -1){
                        bombCount++;
                    }
                    if(cells[i - 9] == -1){
                        bombCount++;
                    }
                    if(cells[i - 1] == -1){
                        bombCount++;
                    }
                }
                else if(i % 9 == 0){ // left middle
                    if(cells[i - 9] == -1){
                        bombCount++;
                    }
                    if(cells[i - 8] == -1){
                        bombCount++;
                    }
                    if(cells[i + 1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 9] == -1){
                        bombCount++;
                    }
                    if(cells[i + 10] == -1){
                        bombCount++;
                    }
                }
                else if((i + 1) % 9 == 0){ // right middle
                    if(cells[i - 10] == -1){
                        bombCount++;
                    }
                    if(cells[i - 9] == -1){
                        bombCount++;
                    }
                    if(cells[i - 1] == -1){
                        bombCount++;
                    }
                    if(cells[i + 8] == -1){
                        bombCount++;
                    }
                    if(cells[i + 9] == -1){
                        bombCount++;
                    }
                }
            }
        }

    }

    private void findBombs() {

    }
}
