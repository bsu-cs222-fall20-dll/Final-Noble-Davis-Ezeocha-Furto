package edu.bsu.cs222.SpaceShip;

import javafx.scene.image.Image;

import java.util.Random;

public class Asteroid implements moveable, drawable{
    //implementing interefaces
    @Override
    public void move(int speed, int direction) {

    }
    private void detectCollision(){

    }

    @Override
    public void draw() {

    }
    //asteroid Specific
    private static final Random asteroids = new Random();
    private static final int asteroidSize =30;
    static final Image aesteroidImage = new Image("C:\\Users\\enile\\IdeaProjects\\Final-Noble-Davis-Ezeocha-Furto\\src\\main\\resources\\SpaceWars\\Asteroids.png");
    static final Image asteroidExplosion = new Image("C:\\Users\\enile\\IdeaProjects\\Final-Noble-Davis-Ezeocha-Furto\\src\\main\\resources\\SpaceWars\\AesteroidExplosion.png");
    static final int explosionWidth= 100;
    static final int explosionHeight = 100;
    static final int explosionRows = 3;
    static final int explosionCol= 3;
    static final int explosionSteps= 15;

    static final  Image fallingAsteroid[] = {
            aesteroidImage,
            aesteroidImage,
            aesteroidImage,
            aesteroidImage,
    };
    final int maxFallingAsteroidAtOneTime = 30, maxShots= maxFallingAsteroidAtOneTime * 2;



}
