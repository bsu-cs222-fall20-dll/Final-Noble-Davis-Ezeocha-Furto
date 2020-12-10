package edu.bsu.cs222;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    }

    private void setCellButtonHandlers() {

    }

    private void updateGoalLabel() {
        mainController.gameNotificationLabel.setText("Goal: Flag 9 mines (" + flagCount + "/" + bombCount + ")");

    }
}
