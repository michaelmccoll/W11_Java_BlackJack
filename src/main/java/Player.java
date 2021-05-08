import java.util.ArrayList;
import java.util.Collections;

public class Player {

    public String name;
    public ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    public int countHand() {
        return this.hand.size();
    }

    public int handTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.cardValue();
        }
        return total;
    }

    public int handTotalMax() {
        int maxTotal = 0;
        for (Card card : this.hand)
            if (card.getRank() == Rank.ACE) {
                maxTotal = handTotal() + 10;
            }
        return maxTotal;
    }

    public String handTotalText() {
        int total = 0;
        int totalAce = 10;
        for (Card card : this.hand) {
            if (card.getRank() != Rank.ACE) {
                total = handTotal();
                return String.format("%s", total);
            } else {
                total = handTotal();
                totalAce = total + totalAce;
                return String.format("%s or %s", total, totalAce);
            }
        }
        return null;
    }

    public String getHand() {
        String cardsInHand = "";
        for (Card card : this.hand){
            cardsInHand = card.cardName();
        }
        return cardsInHand;
    }
}
