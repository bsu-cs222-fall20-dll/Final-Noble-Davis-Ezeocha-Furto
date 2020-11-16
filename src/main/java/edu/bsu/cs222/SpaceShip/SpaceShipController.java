package edu.bsu.cs222.SpaceShip;

import edu.bsu.cs222.Controller;
import edu.bsu.cs222.ProgressBarController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class SpaceShipController {
    @FXML
    Pane space;
    private boolean gameIsCurrentlyBeingPlayed = false;
    private SpaceWars game;
    private Controller mainController;
    final ProgressBarController progressBarController = new ProgressBarController();



}
