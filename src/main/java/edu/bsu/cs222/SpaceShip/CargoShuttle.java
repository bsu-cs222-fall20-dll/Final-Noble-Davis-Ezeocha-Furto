package edu.bsu.cs222.SpaceShip;

public class CargoShuttle  extends SpaceShip{
    @Override
    public void move(int speed) {
        super.move(1);
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
