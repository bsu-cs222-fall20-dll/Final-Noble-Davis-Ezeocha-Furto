package edu.bsu.cs222;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller extends CalendarUI{

    @FXML
    Pane individualGamePane;

    @FXML
    public Label gameName;

    @FXML
    private Pane ProgressBar;

    @FXML
    private Pane ticTacToe;


    @FXML
    private Button startDailyChallengeButton;

    @FXML
    public Label gameNotificationLabel;

    @FXML
    private TicTacToeController ticTacToeController;

    @FXML
    private ProgressBar progressBarController;

    public ArrayList<String> gameList = new ArrayList<>();//all the games to be randomize and create

    private String currentGame = "Main Menu";
    //private int[] gameChosen; fix later


    public void initialize(){
        addGamesToTheGameList();
        //progressBarController.initialize();
        startDailyChallengeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameNotificationLabel.setText("");
                startTicTacToe(0);
            }
        });
    }
    private void addGamesToTheGameList(){
        gameList.add("Tic Tac Toe");
        //gameList.add(ticTacToeController) fix later
    }

    /**public void randomizeGame(){//parse thru game choices and load game
        gameList; //list of games
    }
    public void startChallenge(int mode){//begins daily cha
        randomizeGame();
        currentGame = " ";

        resetGamePane();
        resetProgressBar();
        ticTacToeController.initialize(this,mode);
        ticTacToe.setVisible(true);
        gameName.setText("Tic Tac Toe");

    }*/
    public void startTicTacToe(int mode){
        currentGame ="TicTacToe";
        resetGamePane();
        ticTacToeController.initialize(this, mode);
        ticTacToe.setVisible(true);
        gameName.setText("TicTacToe");
    }

    private void resetGamePane() {
        Pane[] gamePane= new Pane[]{
                ticTacToe
        };
        for (Pane pane : gamePane){
            pane.setVisible(false);
        }
    }


    public void restartProgressBar() {
    }

    public void notifyLoss() {
    }

    public void progressToNextDay(int i) {
    }

    public void notifyWin() {

    }
}
