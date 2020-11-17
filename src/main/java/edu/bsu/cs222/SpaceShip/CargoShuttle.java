package edu.bsu.cs222.SpaceShip;

public class CargoShuttle  extends SpaceShip{
    @Override
    public void move(int speed, int direction) {
        super.move(speed, direction);
    }

    @Override
    public void shipColor() {

    }

    @Override
    public void shipSize() {
        int size = 25;
    }
    private void dropCargo(){

    }
    public CargoShuttle(){
        super("CargoBus");
    }
}
