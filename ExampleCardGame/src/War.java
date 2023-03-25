import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class War {
//TODO: consider making player class to represent player
    //TODO: make scoring function
    //TODO: make ace a high card
    //TODO: add error handling
    //TODO: make more interactive, allow to play one round at a time, solo playing against a computer
    private Deck cardDeck;
    private Queue<Card> playerOneDeck;
    private Queue<Card> playerTwoDeck;
    private Queue<Card> tieDeck;
    private int totalRoundsPlayed;

    War(){
        cardDeck = new Deck();
        cardDeck.initializeDeck();
        playerOneDeck = new LinkedList<>();
        playerTwoDeck = new LinkedList<>();
        tieDeck = new LinkedList<>();
        totalRoundsPlayed = 0;
    }

    public void deal(){
        //should I be saving this as a variable or just call getCardDeck() multiple times?
        Card[] tempDeck = cardDeck.getCardDeck();
        for (int counter = 0; counter < cardDeck.getCardDeck().length; counter++) {
            if (counter % 2 == 0) {
                playerOneDeck.add(tempDeck[counter]);
            } else {
                playerTwoDeck.add(tempDeck[counter]);
            }
        }
    }

    public void playGame(){
        while (playerOneDeck.size() > 0 && playerTwoDeck.size() > 0){
            playRound();
        }
        declareWinner();
    }

    private void playRound(){
        totalRoundsPlayed++;
        Card playerOneCard = playerOneDeck.poll();
        Card playerTwoCard = playerTwoDeck.poll();
        if (playerOneCard.getCardValue() > playerTwoCard.getCardValue()) {
            if (!tieDeck.isEmpty()) {
                settleTie(true);
            }
            playerOneDeck.add(playerOneCard);
            playerOneDeck.add(playerTwoCard);
            System.out.printf("P1 Wins Round #%d, %d vs %d\n", totalRoundsPlayed, playerOneCard.getCardValue(), playerTwoCard.getCardValue());
        } else if (playerOneCard.getCardValue() < playerTwoCard.getCardValue()) {
            if (!tieDeck.isEmpty()) {
                settleTie(false);
            }
            playerTwoDeck.add(playerTwoCard);
            playerTwoDeck.add(playerOneCard);
            System.out.printf("P2 Wins Round #%d, %d vs %d\n", totalRoundsPlayed, playerOneCard.getCardValue(), playerTwoCard.getCardValue());
        } else {
            System.out.printf("Round %d TIE, #%d vs %d\n", totalRoundsPlayed, playerOneCard.getCardValue(), playerTwoCard.getCardValue());
            tieDeck.add(playerOneCard);
            tieDeck.add(playerTwoCard);
            tieBreaker();
        }
        System.out.printf("P1 Deck: ");
        printPlayersDeck(playerOneDeck);
        System.out.println();
        System.out.printf("P2 Deck: ");
        printPlayersDeck(playerTwoDeck);
        System.out.println();
    }

    private void tieBreaker() {
        //TODO: allow for tie to continue if player runs out of cards by using the same card for each tie breaker
        tieDeck.add(playerOneDeck.poll());
        tieDeck.add(playerTwoDeck.poll());
        if (playerOneDeck.size() > 0 && playerTwoDeck.size() > 0) {
            playRound();
        } else {
            declareWinner();
        }
    }

    private void settleTie(boolean playerOneWin){
        if (playerOneWin){
            playerOneDeck.addAll(tieDeck);
        } else {
            playerTwoDeck.addAll(tieDeck);
        }
        tieDeck.clear();
    }

    private void declareWinner(){
        if (playerOneDeck.size() > playerTwoDeck.size()) {
            System.out.println("Player One is the Winner!");
        } else {
            System.out.println("Player Two is the Winner!");
        }
        printPlayersDeck(playerOneDeck);
        System.out.println();
        printPlayersDeck(playerTwoDeck);
    }

    private void printPlayersDeck(Queue<Card> playerDeck){
        for (Card card: playerDeck){
            System.out.printf("%d, ", card.getCardValue());
        }
    }
    //Repeat until someone runs out of cards (loses)
    //scoring function, return size of each player's deck

}
