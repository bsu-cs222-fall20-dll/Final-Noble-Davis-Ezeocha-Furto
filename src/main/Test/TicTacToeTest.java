import edu.bsu.cs222.TicTacToe;
import org.junit.Test;
public class TicTacToeTest {

    @Test
    public void alwaysTrue(){
        assertTrue(true);
    }
    @Test
    public void cellsAre(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playerturn(5);
        assertEquals(ticTacToe.gameStatus.cells[5],1);
    }
    @Test
    public void victoryRecognized(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playerturn(0);
        ticTacToe.playerturn(1);
        ticTacToe.playerturn(2);
        assertEquals("Player", ticTacToe.winner);
    }

}
