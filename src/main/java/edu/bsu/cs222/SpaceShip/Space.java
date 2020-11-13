package edu.bsu.cs222.SpaceShip;

public class Space {
    Asteroid asteroid;
    SpaceShip spaceShip;

    public Space(){//set color of the black space we are acustom to

    }
    public Asteroid getAsteroid(){
        return asteroid;
    }
    public void setAsteroid(Asteroid asteroid){
        this.asteroid = asteroid;
    }
    public SpaceShip getSpaceShip(){
        return spaceShip;
    }
    public void setSpaceShip(SpaceShip spaceShip){
        this.spaceShip = spaceShip;
    }
}
