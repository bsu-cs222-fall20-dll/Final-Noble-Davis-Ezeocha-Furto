package edu.bsu.cs222;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class Controller extends CalendarUI{

    @FXML
    Pane individualGamePane;

    @FXML
    public Label gameName;

    @FXML
    private Pane ticTacToe;
    @FXML
    private Pane minesweeper;

    @FXML
    private Button startDailyChallengeButton;

    @FXML
    private Button instruction;

    @FXML
    public Label gameNotificationLabel;

    @FXML
    private TicTacToeController ticTacToeController;
    @FXML
    private MinesweeperController minesweeperController;

    @FXML
    private ProgressBarController progressBarController;

    public ArrayList<String> gameList = new ArrayList<>();//all the games to be randomize and create
    ArrayList<String> listOfDailyChallenge = new ArrayList<>();
    private String currentGame = "Main Menu";


    public void initialize(){
        addGamesToTheGameList();
        progressBarController.initialize();
        startDailyChallengeButton.setOnAction(event -> {
            gameNotificationLabel.setText("");
            startTicTacToe(0);
            startMinesweeper(0);
            startChallenge(0);
        });
        instruction.setOnAction(event -> showInformation());
        instruction.setFocusTraversable(false);

    }
    private void addGamesToTheGameList(){
        gameList.add("TicTacToe");
        gameList.add("Minesweeper");//for iterartion 3 turn from string to gae object

    }
    private void showInformation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setWidth(200);
        alert.setHeight(300);
        alert.setTitle("Instruction");
        alert.setHeaderText(currentGame + "Instructions");
        switch (currentGame){
            case "TicTacToe":
                alert.setContentText("Click the boxes to place Xs and if you get 3 in a row you win and can advance to the next day of games.");
                break;
            case "Snake":
                alert.setContentText("Use the arrows to manevuever around and each stuff, or the use W to move up, S to move down, A to move left, and D to move right. \n the more you eat the bigger you get. \n Remember don't hit walls or your tail.");
                break;
            case "MineSweeper":
                alert.setContentText("CLer th Space without hitting the bombs");
                break;
        }
        alert.show();
    }

    public void listofChallenges(){
        listOfDailyChallenge.add("Win Once");
        listOfDailyChallenge.add("Win twice");
        listOfDailyChallenge.add("Win thrice");
    }
    //no challenges
    public int challengeId = -1;
    public void setChallengeToNumber(){
        listofChallenges();
        if (listOfDailyChallenge.add("Win Once")) {
            challengeId = 0;
        }
        else if (listOfDailyChallenge.add("Win Twice")){
            challengeId = 1;
        }
        else if(listOfDailyChallenge.add("Win Thrice")){
            challengeId = 2;
        }
        else challengeId = -1;
    }
    public void randomlychooseChallenge(){
        setChallengeToNumber();
        Random random = new Random();
        random.nextInt(challengeId);
    }
    public void startChallenge(int mode){//begins daily challege
        currentGame = " ";
        resetGamePane();
        progressBarController.resetProgressBar();
        ticTacToeController.initialize(this,
                mode);
        ticTacToe.setVisible(true);
        gameName.setText("Tic Tac Toe");
        randomlychooseChallenge();
    }
    public void startTicTacToe(int mode){
        currentGame ="TicTacToe";
        resetGamePane();
        restartProgressBar();
        ticTacToeController.initialize(this, mode);
        ticTacToe.setVisible(true);
        gameName.setText("TicTacToe");
    }
    public void startMinesweeper(int mode){
        currentGame = "Minesweeper";
        if (mode == 1){
            restartProgressBar();
        }
        minesweeperController.initialize(this,mode);
        resetGamePane();
        minesweeper.setVisible(true);
        gameName.setText("Minesweeper");
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
        progressBarController.progressBar.progressProperty();
        progressBarController.resetProgressBar();
    }

    public void notifyLoss() {
        ProgressBarController progressBarController = new ProgressBarController();
        progressBarController.progressBar.progressProperty();
    }

    public void progressToNextDay(int i ) {
        progressBarController.setProgressNumber(100);
        progressToNextDay(1);
        restartProgressBar();
    }


    public void notifyWin() {
        ProgressBarController progressBarController = new ProgressBarController();
        //do you guys think i need to to bind the progress bar to something?
        progressBarController.progressBar.progressProperty();

    }
}
