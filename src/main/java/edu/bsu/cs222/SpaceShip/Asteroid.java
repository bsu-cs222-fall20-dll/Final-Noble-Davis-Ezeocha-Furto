package edu.bsu.cs222.SpaceShip;

import javafx.scene.image.Image;

import java.util.Random;

import static edu.bsu.cs222.SpaceShip.SpaceWars.graphicsContext;

public class Asteroid implements moveable, drawable{
    private int EXPLOSION_Distance;

    //implementing interefaces
    @Override
    public void move(int speed){
    }
    private void detectCollision(){

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
    static int explosionSpans= 15;

    static final  Image fallingAsteroid[] = {
            aesteroidImage,
            aesteroidImage,
            aesteroidImage,
            aesteroidImage,
            aesteroidImage,
    };
    final int maxFallingAsteroidAtOneTime = 30;
    boolean explosion;
    boolean destroyed;
    public void update(){
        if(explosion) explosionSpans++;
        destroyed = explosionSpans > EXPLOSION_Distance;
    }
    @Override
        public void draw() {
        if (explosion) {
            graphicsContext.drawImage(asteroidExplosion, explosionSpans % explosionCol * explosionWidth, (explosionSpans / explosionRows) * explosionHeight + 1, explosionWidth, explosionHeight, positionX, positionY, size);
        }
    }
}
