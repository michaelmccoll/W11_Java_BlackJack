import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
//SETUP GAME
        Player dealer = new Player("Dealer");
        Deck deck = new Deck();
        deck.createNewDeck();

//START GAME
        System.out.println("Welcome to the BlackJack table! I am your Dealer");
        System.out.println("What is your name? ");
        String player1Name = scanner.next();
        Player player1 = new Player(player1Name);

//ASSIGN DEALER 2 CARDS
        Card dealerCard1 = deck.dealCard();
        dealer.takeCard(dealerCard1);
        Card dealerCard2 = deck.dealCard();
        dealer.takeCard(dealerCard2);
        System.out.println(String.format("Lets deal. The Dealers two cards are:",player1.handTotal()));
        System.out.println(String.format("- %s",dealerCard1.cardName()));
        System.out.println("- UNKNOWN");
        System.out.println(String.format("The Dealers score is at least %s",dealerCard1.cardValue()));

//ASSIGN PLAYER1 TWO CARDS
        System.out.println(String.format("%s, here are your two cards:", player1.getName()));
        Card card1 = deck.dealCard();
        player1.takeCard(card1);
        Card card2 = deck.dealCard();
        player1.takeCard(card2);
        System.out.println(String.format("- %s",card1.cardName()));
        System.out.println(String.format("- %s",card2.cardName()));
        System.out.println(String.format("Your total is %s ",player1.handTotalText()));

//PLAYER1 MOVES
        if (player1.handTotal() == 21){
            System.out.println("!!! You have 21, BLACKJACK !!!");
        } else {
            while ((player1.handTotal() <= 21) && ((player1.handTotalMax()) <= 21)){
                System.out.println("Do you want to STICK (enter S) or TWIST (enter T)?");
                String playerMove = scanner.next();
                if (playerMove.equals("S")) {
                    System.out.println("Dealers Turn");
                    if (dealer.handTotal() <= 16){
                        Card card = deck.dealCard();
                        dealer.takeCard(card);
                        System.out.println(dealer.hand);
                        System.out.println(String.format("The Dealer total is %s ",dealer.handTotalText()));
                    } else {
//                        dealer sticks & work out the which hand is more Player or Dealer
                    }

                } else {
                    Card card = deck.dealCard();
                    player1.takeCard(card);
                    System.out.println(player1.getHand());
                    System.out.println(player1.hand);
                    System.out.println(String.format("Your total is %s ",player1.handTotalText()));
                }
            }

        }

    }
}
