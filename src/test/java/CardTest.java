import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card1;

    @Before
    public void setUp(){
        card1 = new Card(Suit.CLUBS,Rank.FIVE);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.CLUBS,card1.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.FIVE,card1.getRank());
    }

    @Test
    public void canSetSuit(){
        card1.setSuit(Suit.HEARTS);
        assertEquals(Suit.HEARTS,card1.getSuit());
    }

    @Test
    public void canSetRank(){
        card1.setRank(Rank.TEN);
        assertEquals(Rank.TEN,card1.getRank());
    }
}
