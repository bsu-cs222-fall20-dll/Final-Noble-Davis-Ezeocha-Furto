package edu.bsu.cs222.SpaceShip;

import edu.bsu.cs222.Controller;
import edu.bsu.cs222.ProgressBarController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.BitSet;

public class SpaceShipController {
    @FXML
    Pane space;
    @FXML
    Button shoot;

    @FXML
    Button spaceShipSwitch;

    private ArrayList<Button> gameplayButtons = new ArrayList<>();
    private boolean gameIsCurrentlyBeingPlayed = false;
    private SpaceWars game;
    private int mode;
    private ChangeListener<Boolean> listener = null;
    private BitSet leftAndRightBitSet = new BitSet();
    private SpaceWarsGameStatus gameStatus;

    private Controller mainController;
    final ProgressBarController progressBarController = new ProgressBarController();
    private enum KEY{
        RIGHT(1),
        LEFT(3);
        final int value;

        KEY(final int newValue){
            value = newValue;
        }
        public int getValue(){
            return value;
        }
    }
    public void initialize(Controller controller, int mode){
        this.mainController = controller;
        this.mode = mode;
        if(listener !=null){
            space.focusedProperty().removeListener(listener);
        }
        startSpaceWars();
        listener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                gameIsCurrentlyBeingPlayed = newValue;
                if(gameIsCurrentlyBeingPlayed){
                    startGame();
                }
            }
        }
        mainController.gameNotificationLabel.setText("Win to see the next Day");
    }

    private void startSpaceWars() {
    }

    private void createGameplayButtonList(){
        gameplayButtons.add(shoot);
        gameplayButtons.add(spaceShipSwitch);
    }


    private void updateGameStatus() {
        game.gameStatus.addMove(0,PlayerNumber(cell0.getText()));
        if (game.gameStatus.checkBoard() !=0 || turnNumber == 9){
            String winner = convertPlayerNumberToString(game.gameStatus.checkBoard());
            gameIsPlaying = false;
            if (winner != null){
                if (winner.equals("Player")){
                    declareVictory();
                }else {
                    declareLoss();
                }
            }
        }
    }
    private void declareVictory() {
        mainController.notifyWin();
        if (mode == 0){
            mainController.progressToNextDay(0);
            progressBarController.setProgressNumber(progressBarController.getProgressNumber() + 1);
        }else if(mode == 1){
            restartGame();
            mainController.restartProgressBar();
        }
    }
    private void declareLoss() {
        mainController.notifyLoss();
        restartGame();
        if (mode == 1){
            mainController.restartProgressBar();
        }
    }
    private void restartGame(){
        startGame();
        game.gameStatus.resetGameGrid();
    }

    private void startGame() {
        gameIsCurrentlyBeingPlayed= true;
        if(gameStatus.spaceWars.points() >= passingLength){
            endSpaceWars();
        }

    }

    private void endSpaceWars() {
        if(mode == 0){
            mainController.notifyProgressBar();
            gameIsCurrentlyBeingPlayed = false;
        }
        if (mode == 1){
            mainController.notifyWin();
            mainController.restartProgressBar();
            mainController.progressToNextDay(1);
        }
    }

    private void getArrowInput(){
        space.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(checkLeftKeyCode(event)){
                    leftAndRightBitSet.set(KEY.RIGHT.getValue());
                }
                else if(checkRightKeyCode(event)){
                    leftAndRightBitSet.set(KEY.LEFT.getValue());
                }
                setDirection();
            }
        });
        space.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                final boolean noLeftAndRightInBitSet = checkNoKeysPressedInBitSet();
                removeKeyFromBitSet(event);
                if(checkLeftKey(event) && noLeftAndRightInBitSet){
                    leftAndRightBitSet.set(KEY.RIGHT.getValue(),true);
                }else if(checkRightKey(event) && noLeftAndRightInBitSet){
                    leftAndRightBitSet.set(KEY.RIGHT.getValue(),true);
                }
                setDirection();
            }
        });

    }
    private void setDirection(){
        boolean leftKeyPressed = leftAndRightBitSet.get(KEY.LEFT.getValue());
        boolean rightKeyPressed = leftAndRightBitSet.get(KEY.RIGHT.getValue());

        int pressedKeys =0;

        if(leftKeyPressed){
            pressedKeys++;
        }
        if(rightKeyPressed){
            pressedKeys++;
        }
        if(pressedKeys > 1){
            return;
        }
        if(leftKeyPressed && gameStatus.l)

    }


}
