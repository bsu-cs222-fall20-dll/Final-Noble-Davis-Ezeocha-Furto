import edu.bsu.cs222.Minesweeper;
import org.junit.Test;
public class MinesweeperTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    @Test
    public void minesweeperCellsAreFlaggedCorrectly() {
        Minesweeper minesweeper = new Minesweeper(9);
        minesweeper.gameStatus.flagCell(0);
        assertTrue(minesweeper.gameStatus.flaggedCells[0]);
    }

}
