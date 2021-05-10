import java.util.ArrayList;
import java.util.Collections;

public class Player {

    public String name;
    public ArrayList<Card> hand;
    public String gameState;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.gameState = "live";
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
        for (Card card : this.hand) {
            if (card.cardValue() != 1) {
                return String.format("%s", handTotal());
            } else {
                return String.format("%s or %s", handTotal(), handTotalMax());
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

    public String getGameState() {
        return gameState;
    }

    public void setGameStateToFinal() {
        this.gameState = "finalHand";
    }

    public void setGameStateToBust() {
        if ((handTotal() > 21) && (handTotalMax()>21)) {
            this.gameState = "BUST!";
        }
    }

    public int bestHand(){
        if (this.handTotalMax() <= 21){
            return this.handTotalMax();
        } else {
            return this.handTotal();
        }
    }

}
