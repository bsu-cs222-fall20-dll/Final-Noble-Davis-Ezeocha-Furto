package edu.bsu.cs222;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;


public class ProgressBarController {

    @FXML
    private Label progressBarLabel;
    private DoubleProperty progressNumber;
    ProgressBar progressBar = new ProgressBar();
    //doubleProperty For The ProgressIndicator
    public final double getProgressNumber(){
        if (progressNumber != null)
            return progressNumber.get();
            return 0;
    }
    public final void setProgressNumber(double progressNumber){
        this.progressProperty().set(progressNumber);
    }
    public final DoubleProperty progressProperty(){
        if (progressNumber == null){
            progressNumber = new SimpleDoubleProperty(0);
        }
        return progressNumber;
    }

    //ProgressBar

    public void initialize(){

    }





    public void resetProgressBar(){

    }
}