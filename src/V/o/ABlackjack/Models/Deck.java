package V.o.ABlackjack.Models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static final ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        
        deck.add(new Card(Faces.TWO, Suit.HEARTS));
        deck.add(new Card(Faces.TWO, Suit.DIAMOND));
        deck.add(new Card(Faces.TWO, Suit.CLUBS));
        deck.add(new Card(Faces.TWO, Suit.SPADES));
        deck.add(new Card(Faces.THREE, Suit.DIAMOND));
        deck.add(new Card(Faces.THREE, Suit.HEARTS));
        deck.add(new Card(Faces.THREE, Suit.CLUBS));
        deck.add(new Card(Faces.THREE, Suit.SPADES));
        deck.add(new Card(Faces.FOUR, Suit.DIAMOND));
        deck.add(new Card(Faces.FOUR, Suit.HEARTS));
        deck.add(new Card(Faces.FOUR, Suit.CLUBS));
        deck.add(new Card(Faces.FOUR, Suit.SPADES));
        deck.add(new Card(Faces.FIVE, Suit.DIAMOND));
        deck.add(new Card(Faces.FIVE, Suit.HEARTS));
        deck.add(new Card(Faces.FIVE, Suit.CLUBS));
        deck.add(new Card(Faces.FIVE, Suit.SPADES));
        deck.add(new Card(Faces.SIX, Suit.DIAMOND));
        deck.add(new Card(Faces.SIX, Suit.HEARTS));
        deck.add(new Card(Faces.SIX, Suit.CLUBS));
        deck.add(new Card(Faces.SIX, Suit.SPADES));
        deck.add(new Card(Faces.SEVEN, Suit.DIAMOND));
        deck.add(new Card(Faces.SEVEN, Suit.HEARTS));
        deck.add(new Card(Faces.SEVEN, Suit.CLUBS));
        deck.add(new Card(Faces.SEVEN, Suit.SPADES));
        deck.add(new Card(Faces.EIGHT, Suit.DIAMOND));
        deck.add(new Card(Faces.EIGHT, Suit.HEARTS));
        deck.add(new Card(Faces.EIGHT, Suit.CLUBS));
        deck.add(new Card(Faces.EIGHT, Suit.SPADES));
        deck.add(new Card(Faces.NINE, Suit.DIAMOND));
        deck.add(new Card(Faces.NINE, Suit.HEARTS));
        deck.add(new Card(Faces.NINE, Suit.CLUBS));
        deck.add(new Card(Faces.NINE, Suit.SPADES));
        deck.add(new Card(Faces.TEN, Suit.DIAMOND));
        deck.add(new Card(Faces.TEN, Suit.HEARTS));
        deck.add(new Card(Faces.TEN, Suit.CLUBS));
        deck.add(new Card(Faces.TEN, Suit.SPADES));
        deck.add(new Card(Faces.JACK, Suit.DIAMOND));
        deck.add(new Card(Faces.JACK, Suit.HEARTS));
        deck.add(new Card(Faces.JACK, Suit.CLUBS));
        deck.add(new Card(Faces.JACK, Suit.SPADES));
        deck.add(new Card(Faces.QUEEN, Suit.DIAMOND));
        deck.add(new Card(Faces.QUEEN, Suit.HEARTS));
        deck.add(new Card(Faces.QUEEN, Suit.CLUBS));
        deck.add(new Card(Faces.QUEEN, Suit.SPADES));
        deck.add(new Card(Faces.KING, Suit.DIAMOND));
        deck.add(new Card(Faces.KING, Suit.HEARTS));
        deck.add(new Card(Faces.KING, Suit.CLUBS));
        deck.add(new Card(Faces.KING, Suit.SPADES));
        deck.add(new Card(Faces.ACE11, Suit.DIAMOND));
        deck.add(new Card(Faces.ACE11, Suit.HEARTS));
        deck.add(new Card(Faces.ACE11, Suit.CLUBS));
        deck.add(new Card(Faces.ACE11, Suit.SPADES));

    }
    public static void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public void moveCardToBottom(){
        Card ph = deck.get(0);
        deck.remove(0);
        deck.add(ph);
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }


}
