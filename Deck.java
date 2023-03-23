import java.util.Random;

public class Deck {
    private Card[] cardDeck;
    private boolean isCreated;
    private boolean isShuffled;

    Deck() {
        cardDeck = new Card[52];
        isCreated = false;
        isShuffled = false;
    }

    public Card[] getCardDeck() {
        return cardDeck;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public boolean isShuffled() {
        return isShuffled;
    }

    public void createDeck() {
        int cardDeckIndex = 0;
        for (Suit suit : Suit.values()) {
            for (int i = 1; i < 14; i++){
                cardDeck[cardDeckIndex++] = new Card(i, suit);
            }
        }
        isCreated = true;
    }

    //TODO: develop algorithm to calculate how shuffled a deck is
    public void shuffleDeck() {
        Random rnd = new Random();
        for (int i = 0; i < 52; i++) {
            Card tempCard = new Card(cardDeck[i]);
            int randomNum = rnd.nextInt(52);
            cardDeck[i] = cardDeck[randomNum];
            cardDeck[randomNum] = tempCard;
        }
    }

    public void printDeck() {
        for (Card card : cardDeck) {
            card.printCard();
        }
    }
}
