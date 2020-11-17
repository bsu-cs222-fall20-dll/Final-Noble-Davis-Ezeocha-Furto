package edu.bsu.cs222.SpaceShip;

public class RoidBlaster extends Weapons {

    @Override
    public void fireRate(int x, int y) {
        super.fireRate(100,9);
    }

    @Override
    public void shoot(boolean fire) {
        super.shoot(true);
    }

    @Override
    public void reloadSpeed(int y) {
        super.reloadSpeed(10);
    }

    @Override
    public void ammoCapacity(int capacity) {
        super.ammoCapacity(150);
    }

    @Override
    public void ammoColor() {

    }
}
