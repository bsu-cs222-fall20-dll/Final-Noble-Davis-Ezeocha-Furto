package edu.bsu.cs222;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class MinesweeperController {
    @FXML
    private List<Button> buttons;

    private Controller mainController;
    private Minesweeper game;

    private int bombCount = 9;
    private int flagCount = 0;
    private int mode;

    public void initialize(Controller controller, int mode){
        this.mainController = controller;
        this.mode = mode;
        game = new Minesweeper(bombCount);
        setCellButtonHandlers();
        resetBoard();
        game.start();
        updateGoalLabel();
    }

    private void resetBoard() {
        for (Button cell : buttons){
            cell.setText("");
            cell.setStyle("-fx-background-color: #dbdbdb");
        }
    }

    private void setCellButtonHandlers() {
        for (int i = 0; i < buttons.size(); i++){
            final Button block = buttons.get(i);
            block.setOnMouseClicked(makeEventHandlerForCell(i));
        }
    }

    private EventHandler<? super MouseEvent> makeEventHandlerForCell(int i) {
        EventHandler<MouseEvent> eventHandler;
        eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MouseButton button = event.getButton();
                if (button == MouseButton.PRIMARY){
                    sweepCell(i);
                }else if(button == MouseButton.SECONDARY){
                    flagged(i);
                }
            }
        };
        return eventHandler;
    }

    private void sweepCell(int index) {
        int cell = game.gameStatus.cells[index];
        if (game.gameStatus.shownCells[index] || game.gameStatus.flaggedCells[index]){
            return;
        }
        if (cell == -1){
            revealBombs();
            checkVictory();
        }
        else if (cell == 0){
            revealWhereNoBombsAre(index);
            checkVictory();
        }
        else{
            buttons.get(index).setText("" + cell);
            buttons.get(index).setStyle("-fx-background-color: #8fcae5");
            game.gameStatus.revealCell(index);
            checkVictory();
        }

    }

    private void revealWhereNoBombsAre(int index) {
        int[] cells = game.gameStatus.cells;
        boolean[] shownCells = game.gameStatus.shownCells;
        if (shownCells[index]){
            return;
        }
        buttons.get(index).setStyle("-fx-background-color: #8fcae5");
        game.gameStatus.revealCell(index);
        revealTheCloseCells(index);
        if(index == 0){ //top left
            if(cells[index + 1] == 0){
                revealWhereNoBombsAre(index + 1);
            }
            if(cells[index + 9] == 0){
                revealWhereNoBombsAre(index + 9);
            }
        }
        else if(index < 8){ //top middle
            if(cells[index - 1] == 0){
                revealWhereNoBombsAre(index - 1);
            }
            if(cells[index + 1] == 0){
                revealWhereNoBombsAre(index + 1);
            }
            if(cells[index + 9] == 0){
                revealWhereNoBombsAre(index + 9);
            }
        }
        else if(index == 8){ //top right
            if(cells[index - 1] == 0){
                revealWhereNoBombsAre(index - 1);
            }
            if(cells[index + 9] == 0){
                revealWhereNoBombsAre(index + 9);
            }
        }
        else if(index == 72){ // bottom left
            if(cells[index - 9] == 0){
                revealWhereNoBombsAre(index - 9);
            }
            if(cells[index + 1] == 0){
                revealWhereNoBombsAre(index + 1);
            }
        }
        else if(index > 72 && index < 80){ // bottom middle
            if(cells[index - 9] == 0){
                revealWhereNoBombsAre(index - 9);
            }
            if(cells[index - 1] == 0){
                revealWhereNoBombsAre(index - 1);
            }
            if(cells[index + 1] == 0){
                revealWhereNoBombsAre(index + 1);
            }
        }
        else if(index == 80){ // bottom left
            if(cells[index - 9] == 0){
                revealWhereNoBombsAre(index - 9);
            }
            if(cells[index - 1] == 0){
                revealWhereNoBombsAre(index - 1);
            }
        }
        else if(index % 9 == 0){ // left middle
            if(cells[index - 9] == 0){
                revealWhereNoBombsAre(index - 9);
            }
            if(cells[index + 1] == 0){
                revealWhereNoBombsAre(index + 1);
            }
            if(cells[index + 9] == 0){
                revealWhereNoBombsAre(index + 9);
            }
        }
        else if((index + 1) % 9 == 0){ // right middle
            if(cells[index - 9] == 0){
                revealWhereNoBombsAre(index - 9);
            }
            if(cells[index - 1] == 0){
                revealWhereNoBombsAre(index - 1);
            }
            if(cells[index + 9] == 0){
                revealWhereNoBombsAre(index + 9);
            }
        }
        else{ //center
            if(cells[index - 9] == 0){
                revealWhereNoBombsAre(index - 9);
            }
            if(cells[index - 1] == 0){
                revealWhereNoBombsAre(index - 1);
            }
            if(cells[index + 1] == 0){
                revealWhereNoBombsAre(index + 1);
            }
            if(cells[index + 9] == 0){
                revealWhereNoBombsAre(index + 9);
            }
        }
    }

    private void revealTheCloseCells(int index) {
        if (index == 0){
            sweepCell(index + 1);
            sweepCell(index + 9);
            sweepCell(index + 10);
        }
        else if (index < 8){
            sweepCell(index - 1);
            sweepCell(index + 1);
            sweepCell(index + 8);
            sweepCell(index + 9);
            sweepCell(index + 10);
        }
        else if(index == 8){ //top right
            sweepCell(index - 1);
            sweepCell(index + 8);
            sweepCell(index + 9);
        }
        else if(index == 72){ // bottom left
            sweepCell(index - 9);
            sweepCell(index - 8);
            sweepCell(index + 1);
        }
        else if(index > 72 && index < 80){ // bottom middle
            sweepCell(index - 10);
            sweepCell(index - 9);
            sweepCell(index - 8);
            sweepCell(index - 1);
            sweepCell(index + 1);
        }
        else if(index == 80){ // bottom left
            sweepCell(index - 10);
            sweepCell(index - 9);
            sweepCell(index - 1);
        }
        else if(index % 9 == 0){ // left middle
            sweepCell(index - 9);
            sweepCell(index - 8);
            sweepCell(index + 1);
            sweepCell(index + 9);
            sweepCell(index + 10);
        }
        else if((index + 1) % 9 == 0){ // right middle
            sweepCell(index - 10);
            sweepCell(index - 9);
            sweepCell(index - 1);
            sweepCell(index + 8);
            sweepCell(index + 9);
        }
        else{ //center
            sweepCell(index - 10);
            sweepCell(index - 9);
            sweepCell(index - 8);
            sweepCell(index - 1);
            sweepCell(index + 1);
            sweepCell(index + 8);
            sweepCell(index + 9);
            sweepCell(index + 10);
        }

    }

    private void revealBombs() {
        for (int i = 0; i < buttons.size(); i++){
            int cell = game.gameStatus.cells[i];
            if (cell == -1){
                buttons.get(i).setText("&#xe311;");
                buttons.get(i).setStyle("-fx-background-color: #ff0000");
            }
        }
        mainController.notifyLoss();
        restartGame();
        if (mode == 1){
            mainController.restartProgressBar();
        }

    }

    private void restartGame() {
        flagCount = 0;
        updateGoalLabel();
        resetBoard();
        game.gameStatus.reset();
        game.start();
    }

    private void checkVictory() {
        boolean[] bombCells = game.gameStatus.bombCells;
        boolean[] shownCells = game.gameStatus.shownCells;
        boolean[] flaggedCells = game.gameStatus.flaggedCells;
        int shownCellCount = 0;
        int flaggedBombs = 0;
        for (int bomb = 0; bomb < 81; bomb++){
            if (bombCells[bomb] && !flaggedCells[bomb]){
                return;
            }
            if(bombCells[bomb] && flaggedCells[bomb]){
                flaggedBombs++;
            }
        }
        
    }

    private void flagged(int i) {
        boolean isCellFlagged = game.gameStatus.flaggedCells[i];
        if (game.gameStatus.shownCells[i]){
            return;
        }
        if (isCellFlagged){
            game.gameStatus.unflagCell(i);
            buttons.get(i).setText("");
            flagCount--;
            updateGoalLabel();
        }
        else {
            game.gameStatus.flagCell(i);
            buttons.get(i).setText("F");
        }

    }

    private void updateGoalLabel() {
        mainController.gameNotificationLabel.setText("Goal: Flag 9 mines (" + flagCount + "/" + bombCount + ")");
    }

}
