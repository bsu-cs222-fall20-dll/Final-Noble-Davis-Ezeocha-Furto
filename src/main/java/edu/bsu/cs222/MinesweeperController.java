package edu.bsu.cs222;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class MinesweeperController {
    @FXML
    private List<Button> cells;

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
        for (Button cell : cells){
            cell.setText("");
            cell.setStyle("-fx-background-color: #dbdbdb");
        }
    }

    private void setCellButtonHandlers() {
        for (int i = 0; i < cells.size(); i++){
            final Button block = cells.get(i);
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
            cells.get(index).setText("" + cell);
            cells.get(index).setStyle("-fx-background-color: #8fcae5");
            game.gameStatus.revealCell(index);
            checkVictory();
        }

    }

    private void revealWhereNoBombsAre(int index) {
    }

    private void revealBombs() {
        for (int i = 0; i < cells.size(); i++){
            int cell = game.gameStatus.cells[i];
            if (cell == -1){
                cells.get(i).setText("&#xe311;");
                cells.get(i).setStyle("-fx-background-color: #ff0000");
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
        
    }

    private void flagged(int i) {

    }

    private void updateGoalLabel() {
        mainController.gameNotificationLabel.setText("Goal: Flag 9 mines (" + flagCount + "/" + bombCount + ")");
    }

}
