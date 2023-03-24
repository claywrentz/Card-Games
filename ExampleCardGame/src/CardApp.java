public class CardApp {
    public static void main(String[] args) {
        //TODO: create a game
        Deck newDeck = new Deck();
        newDeck.createDeck();
        newDeck.printDeck();
        newDeck.shuffleDeck();
        newDeck.printDeck();
    }
}
