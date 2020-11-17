package edu.bsu.cs222.SpaceShip;



public class SpaceWarsGameStatus {
    int asteroidDestroyed;
    public int checkBenchmark() {
        int benchMark= 50;
        if(asteroidDestroyed > benchMark){
            return 0;
        }
        return benchMark;
    }
}
