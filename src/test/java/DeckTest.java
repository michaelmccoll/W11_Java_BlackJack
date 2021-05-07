import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck1;

    @Before
    public void setUp(){
        deck1 = new Deck();
        deck1.createNewDeck();
    }

    @Test
    public void canCreateNewDeck(){
        assertEquals(52,deck1.countDeck());
    }

    @Test
    public void canDealOneCard(){
        deck1.dealCard();
        assertEquals(51, deck1.countDeck());
    }
}
