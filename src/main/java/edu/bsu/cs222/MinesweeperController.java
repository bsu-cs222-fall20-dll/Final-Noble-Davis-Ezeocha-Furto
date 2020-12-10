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

    }
}
