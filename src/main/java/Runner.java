import java.util.Scanner;

public class Runner {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Player dealer = new Player("Dealer");
        Deck deck = new Deck();
        deck.createNewDeck();

        System.out.println("Welcome to the BlackJack table! I am your Dealer");
        System.out.println("What is your name? ");
        String player1Name = scanner.next();
        Player player1 = new Player(player1Name);

//        Assign the dealers 2 cards
        Card dealerCard1 = deck.dealCard();
        dealer.takeCard(dealerCard1);
        Card dealerCard2 = deck.dealCard();
        dealer.takeCard(dealerCard2);
        System.out.println(String.format("Lets deal, my two cards:",player1.handTotal()));
        System.out.println(String.format("- %s",dealerCard1.cardName()));
        System.out.println("- UNKNOWN");
        System.out.println(String.format("Dealers is at least %s",dealerCard1.cardValue()));


        System.out.println(String.format("%s, here are your two cards:", player1.getName()));
        Card card1 = deck.dealCard();
        player1.takeCard(card1);
        Card card2 = deck.dealCard();
        player1.takeCard(card2);
        System.out.println(String.format("- %s",card1.cardName()));
        System.out.println(String.format("- %s",card2.cardName()));
        System.out.println(String.format("Your total is either %s or %s ",player1.handTotal(),player1.handTotalAce()));

        if (player1.handTotalAce() == 21){
            System.out.println("!!! You have 21, BLACKJACK !!!");
        } else {
            while ((player1.handTotal() <= 21) && (player1.handTotalAce() <= 21)){
                System.out.println("Do you want to STICK or TWIST?");
                String playerMove = scanner.next();
                if (playerMove.equals("TWIST")) {
                    Card card = deck.dealCard();
                    player1.takeCard(card);
                    System.out.println(player1.getHand());
                    System.out.println(String.format("Your total is either %s or %s ",player1.handTotal(),player1.handTotalAce()));
                } else {
                    System.out.println("Dealers Turn");
                }
            }
        }

//        while ((player1.handTotal() OR player1.handTotalAce()) <= 21){


    }
}
