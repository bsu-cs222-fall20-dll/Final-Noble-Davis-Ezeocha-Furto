package edu.bsu.cs222.SpaceShip;

public abstract class SpaceShip implements moveable {
    int shieldStrength;
    String spaceshipName;

    public SpaceShip(String spaceshipName){
        this.spaceshipName = spaceshipName;
    }

    @Override
    public void move(int speed) {

    }
    void getshieldStrength(){

    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
    public abstract void shipColor();
    public abstract void shipSize();
}
