package edu.bsu.cs222.SpaceShip;

import javafx.scene.image.Image;

import java.util.List;

public abstract class BattleShip extends Weapons implements moveable,drawable{
    static String shipName;
    static Image rocket = new Image("");
    int positionX;
    int positionY;
    int size;
    Asteroid asteroid = new Asteroid();
    int placeholderNumber = 2;
    int maxShots;

    public BattleShip(String shipName, Image rocket,int positionX, int positionY, int size){
        BattleShip.shipName = shipName;
        BattleShip.rocket = rocket;
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        //this.maxShots = asteroid.maxFallingAsteroidAtOneTime * placeholderNumber;
    }
    @Override
    public void fireRate(int x, int y ) {
        super.fireRate(x,y);
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
    }
}
