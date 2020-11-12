package edu.bsu.cs222;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;


public class ProgressBarController {

    @FXML
    private Label progressBarLabel;
    public DoubleProperty progressNumber;
    ProgressBar progressBar = new ProgressBar();
    @FXML
    private ProgressIndicator progressIndicator;

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
        progressBar.progressProperty().bind(progressNumber);

    }





    public void resetProgressBar(){

    }
}