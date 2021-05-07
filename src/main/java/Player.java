import java.util.ArrayList;
import java.util.Collections;

public class Player {

    public String name;
    public ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    public int countHand() {
        return this.hand.size();
    }

    public int handTotal(){
        int total = 0;
        for (Card card : this.hand){
            total += card.cardValue();
        }
        return total;
    }

    public int handTotalAce(){
        int total = 0;
        for (Card card : this.hand){
            total += card.cardSecondValue();
        }
        return total;
    }

//
//    public int getAllTotals() {
//        ArrayList<Integer> totals = new ArrayList<Integer>();
//        for (Card card : this.hand){
//            for (Rank rank : Rank.values()){
//            totals += card.cardValue();
//            }
//        }
//    }


}
