package edu.bsu.cs222.SpaceShip;

public class VIbeBreaker extends Weapons{

    @Override
    public void fireRate(int x) {
        super.fireRate(x);
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
}
