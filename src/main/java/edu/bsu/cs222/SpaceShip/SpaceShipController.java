package edu.bsu.cs222.SpaceShip;

import edu.bsu.cs222.Controller;
import edu.bsu.cs222.ProgressBarController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

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

    private Controller mainController;
    final ProgressBarController progressBarController = new ProgressBarController();

    public void initialize(Controller controller, int mode){
        this.mainController = controller;
        this.mode = mode;
        startGame();

        mainController.gameNotificationLabel.setText("Win to see the next Day");
    }
    private void createGameplayButtonList(){
        gameplayButtons.add(shoot);
        gameplayButtons.add(spaceShipSwitch);
    }
    private void playersAction(int asteroidDestroyed){
        gameStatus.countPoint(asteroidDestroyed);
        checkVictory();//if destroyed amount required
    }
    private void checkVictory(){
        if(gameStatus.checkBenchmark() !=0){
            declareWin(gameStatus.checkBenchmark());
        }
    }
    private void updateGameStatus() {
        game.gameStatus.addMove(0,PlayerNumber(cell0.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell1.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell2.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell3.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell4.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell5.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell6.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell7.getText()));
        game.gameStatus.addMove(0,PlayerNumber(cell8.getText()));
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
        game = new SpaceWars();

    }


}
