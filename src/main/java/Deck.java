import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
    }

    public void createNewDeck() {
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(suit,rank);
                this.cards.add(card);
            }
        }
        Collections.shuffle(this.cards);
    }

    public int countDeck() {
        return this.cards.size();
    }
}
