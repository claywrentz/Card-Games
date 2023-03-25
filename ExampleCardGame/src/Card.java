public class Card {
    private int cardValue;
    private Suit suit;
    private Color color;

    Card(int cardValue, Suit suit){
        this.cardValue = cardValue;
        this.suit = suit;
        color = (suit == Suit.HEARTS || suit == Suit.DIAMONDS) ? Color.RED : Color.BLACK;
    }

    Card(Card card){
        this.cardValue = card.cardValue;
        this.suit = card.suit;
        this.color = card.color;
    }

    public int getCardValue() {
        return cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Color getColor() {
        return color;
    }
    private String cardValueToString(){
        switch(cardValue){
            case 1: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "Err";
        }
    }
    public void printCard(){
        System.out.printf("%s of %s (%s)\n", cardValueToString(), suit.toString(), color.toString());
    }
}
