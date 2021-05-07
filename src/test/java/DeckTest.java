import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck1;

    @Before
    public void setUp(){
        deck1 = new Deck();
    }

    @Test
    public void canCreateNewDeck(){
        deck1.createNewDeck();
        assertEquals(52,deck1.countDeck());
    }
}
