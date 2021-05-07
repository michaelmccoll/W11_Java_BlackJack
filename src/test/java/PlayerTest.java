import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Card card1;

    @Before
    public void setUp(){
        player1 = new Player("Michael");
        card1 = new Card(Suit.SPADES,Rank.SEVEN);
    }

    @Test
    public void canGetName() {
        assertEquals("Michael", player1.getName());
    }

    @Test
    public void canSetName(){
        player1.setName("Michael McColl");
        assertEquals("Michael McColl",player1.getName());
    }

    @Test
    public void canTakeCard(){
        player1.takeCard(card1);
        assertEquals(1,player1.countHand());
    }
}
