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
        Dealer.dealCard(deck,dealer);
        Dealer.dealCard(deck,dealer);
        System.out.println(String.format("Lets deal. The Dealers two cards are:",dealer.handTotal()));
        System.out.println(String.format("- %s",dealer.hand.get(0).cardName()));
        System.out.println("- UNKNOWN");
        System.out.println(String.format("The Dealers score is at least %s",dealer.hand.get(0).cardValue()));

//ASSIGN PLAYER1 TWO CARDS
        System.out.println(String.format("%s, here are your two cards:", player1.getName()));
        Dealer.dealCard(deck,player1);
        Dealer.dealCard(deck,player1);
        System.out.println(String.format("- %s",player1.hand.get(0).cardName()));
        System.out.println(String.format("- %s",player1.hand.get(1).cardName()));
        System.out.println(String.format("Your total is %s ",player1.handTotalText()));

//PLAYER1 MOVES
        if ((player1.handTotal() == 21) || (player1.handTotalMax() == 21)){
            System.out.println("!!! You have 21, BLACKJACK !!!");
        } else {
            while (player1.getGameState().equals("live")){
                System.out.println("Do you want to STICK (enter S) or TWIST (enter T)?");
                String playerMove = scanner.next();
                if (playerMove.equals("S") || playerMove.equals("s")) {
                    player1.setGameStateToFinal();
                    System.out.println("Dealers Turn");
                    if (dealer.bestHand() <= 16){
                        Dealer.dealCard(deck,dealer);
                        dealer.setGameStateToFinal();
                        System.out.println(String.format("The Dealer total is %s or %s",dealer.handTotal(),dealer.handTotalMax()));
                    }
                } else {
                    Dealer.dealCard(deck,player1);
                    System.out.println(player1.getHand());
                    System.out.println(String.format("Your total is %s or %s",player1.handTotal(),player1.handTotalMax()));
                }
            }
            System.out.println(String.format("The winner is %s ",getResult()));
        }

        }
    }
