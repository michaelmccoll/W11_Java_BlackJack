public class Dealer {

    private String dealer;

    public Dealer(String dealer){
        this.dealer = "Dealer";
    }

    public static void dealCard(Deck deck, Player player){
        Card dealtCard = deck.dealCard();
        player.takeCard(dealtCard);
    }
}
