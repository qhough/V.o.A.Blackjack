package V.o.ABlackjack.Models;

public class Card {
    private Faces value;
    private Suit suit;

    public Card(Faces newValue, Suit newSuit){
        value = newValue;
        suit = newSuit;
    }

    public Object getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

    public String toString(){
        String description = "";
        if(value.getValue()!=10) {
            description = String.valueOf(value.getValue());
        }else{
            if(value==Faces.TEN){
                description = String.valueOf(value.getValue());
            }else if(value==Faces.JACK){
                description = "Jack";
            }else if(value==Faces.QUEEN){
                description = "Queen";
            }else{
                description = "King";
            }
        }
        description += " of ";
        if(suit==Suit.HEARTS){
            description += "Hearts";
        }else if (suit==Suit.SPADES){
            description += "Spades";
        }else if (suit==Suit.CLUBS){
            description += "Clubs";
        }else{
            description += "Diamonds";
        }
        return description;
    }
}
