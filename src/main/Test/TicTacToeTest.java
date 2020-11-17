import edu.bsu.cs222.TicTacToe;
import org.junit.Test;
import static org.junit.Assert.*;
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
    @Test
    public void rowsMarkedCorrectly(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playerturn(4);
        assertEquals(1,ticTacToe.gameStatus.row2[1]);
    }
    @Test
    public void columnsMarkedCorrectly(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playerturn(4);
        assertEquals(1, ticTacToe.gameStatus.col2[1]);
    }
    @Test
    public void diagonalsMarkedCorrectly(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playerturn(4);
        assertEquals(1, ticTacToe.gameStatus.diag1[1]);
    }

}
