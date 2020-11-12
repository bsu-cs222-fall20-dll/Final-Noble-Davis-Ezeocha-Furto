package edu.bsu.cs222;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class TicTacToeController {

    @FXML
    GridPane board;

    @FXML
    Button cell0;

    @FXML
    Button cell1;

    @FXML
    Button cell2;

    @FXML
    Button cell3;

    @FXML
    Button cell4;

    @FXML
    Button cell5;

    @FXML
    Button cell6;

    @FXML
    Button cell7;

    @FXML
    Button cell8;

    private ArrayList<Button> cellList = new ArrayList<>();
    private int turnNumber = 0;
    private int mode;
    private boolean gameIsPlaying = false;
    private TicTacToe game;
    private Controller mainController;
    final ProgressBarController progressBarController = new ProgressBarController();

    public void initialize(Controller controller, int mode){
        this.mainController = controller;
        this.mode = mode;
        startGame();
    }
    @FXML
    private void CellZero(){
        if (cell0.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell0.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellOne(){
        if (cell1.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell1.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellTwo(){
        if (cell2.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell2.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellThree(){
        if (cell3.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell3.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellFour(){
        if (cell4.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell4.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellFive(){
        if (cell5.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell5.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellSix(){
        if (cell6.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell6.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellSeven(){
        if (cell7.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell7.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    @FXML
    private void CellEight(){
        if (cell8.getText().equals("") && gameIsPlaying){
            turnNumber++;
            cell8.setText("X");
            updateGameStatus();
            if (turnNumber % 2 == 1){
                computerMove();
            }
        }
    }
    private void startGame(){
        gameIsPlaying= true;
        game = new TicTacToe();
        turnNumber = 0;
        cellList = new ArrayList<>();
        fillCellList();
        resetBoard();
        mainController.gameNotificationLabel.setText("Win to see the next Day");
    }

    private void fillCellList() {
        cellList.add(cell0);
        cellList.add(cell1);
        cellList.add(cell2);
        cellList.add(cell3);
        cellList.add(cell4);
        cellList.add(cell5);
        cellList.add(cell6);
        cellList.add(cell7);
        cellList.add(cell8);
    }
    private void computerMove() {
        ArrayList<Integer> openCells = game.gameStatus.findOpenCells();
        turnNumber++;
        if(openCells.size() > 0 && gameIsPlaying) {
            int cell = game.computerTurn();
            if(cell == -1) {
                int randomInt = (int) (Math.random() * openCells.size());
                Button chosenButton = cellList.get(openCells.get(randomInt));
                chosenButton.setText("O");
            }
            else{
                Button chosenButton = cellList.get(cell);
                chosenButton.setText("O");
            }
            updateGameStatus();
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

    private void declareLoss() {
        mainController.notifyLoss();
        restartGame();
        if (mode == 1){
            mainController.restartProgressBar();
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

    private void restartGame() {
        resetBoard();
        startGame();
        game.gameStatus.resetGameGrid();
    }

    private void resetBoard() {
        for(Button cell : cellList){
            cell.setText("");
        }
    }

    private int PlayerNumber(String text) {
        switch (text) {
            case "":
                return 0;

            case "X":
                return 1;

            case "O":
                return 2;
        }
        return 0;
    }

    private String convertPlayerNumberToString(int playerId) {
        if(playerId == 0) {
            return "Nobody";
        }
        else if(playerId == 1){
            return "Player";
        }
        else if(playerId == 2){
            return "Computer";
        }
        return null;
    }
}
