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

    private void sweepCell(int i) {

    }

    private void flagged(int i) {

    }

    private void updateGoalLabel() {
        mainController.gameNotificationLabel.setText("Goal: Flag 9 mines (" + flagCount + "/" + bombCount + ")");
    }

}
