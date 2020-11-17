package edu.bsu.cs222.SpaceShip;

import javafx.scene.image.Image;
import static edu.bsu.cs222.SpaceShip.SpaceWars.graphicsContext;


public class VIbeBreaker extends BattleShip{
    static final Image vibeBreaker = new Image("C:\\Users\\enile\\IdeaProjects\\Final-Noble-Davis-Ezeocha-Furto\\src\\main\\resources\\SpaceWars");
    public VIbeBreaker(){
        super("VibeBreaker", vibeBreaker,30,30,10);
    }
    @Override
    public void fireRate(int x, int y) {
        super.fireRate((positionX + size)/100 - size/2, positionY - size);
    }

    @Override
    public void shoot(boolean fire) {
        super.shoot(true);
    }


    @Override
    public void reloadSpeed(int y) {
        super.reloadSpeed(1);
    }

    @Override
    public void ammoCapacity(int capacity) {
        super.ammoCapacity(200);
    }

    @Override
    public void ammoColor() {

    }



    @Override
    public void move(int speed) {
        super.move(30);
        graphicsContext.drawImage(vibeBreaker,positionX,positionY,15,30,);

    }
    @Override
    public void draw() {
        graphicsContext.drawImage(vibeBreaker,0,0,25,15);
    }
}

