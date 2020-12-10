package edu.bsu.cs222;

public class Minesweeper {

    private int bombId;
    public Minesweeper(int bombCount){
        this.bombId = bombCount;
    }
    public final MinesweeperGameStatus gameStatus = new MinesweeperGameStatus();

    void start(){
        gameStatus.makeNewBoard(bombId);
    }
}
