package edu.bsu.cs222.SpaceShip;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceWars {


    public static GraphicsContext graphicsContext;
    private void playersAction(int asteroidDestroyed){
        gameStatus.countPoint(asteroidDestroyed);
        checkVictory();//if destroyed amount required
    }


    private void checkVictory(){
        if(gameStatus.checkBenchmark() !=0){
            declareWin(gameStatus.checkBenchmark());
        }
    }
    private void declareWin(int winner){
        if (winner == 1){
            this.winner = "Player";
        }
        else {
            new Image("C:\\Users\\enile\\IdeaProjects\\Final-Noble-Davis-Ezeocha-Furto\\src\\main\\resources\\SpaceWars\\ha-ha-you-lose.png");
        }
    }
}
