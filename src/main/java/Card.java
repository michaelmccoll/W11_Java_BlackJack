public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String cardName(){
        return String.format("%s of %s", this.rank,this.suit);
    }

    public int cardValue(){
        return this.rank.getValue();
    }

}
