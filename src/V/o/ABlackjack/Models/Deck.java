package V.o.ABlackjack.Models;

public class Deck {
    public void generateDeck(){
        Card[][] newDeck = new Card[4][13];
        for(int currSuit=0; currSuit<=3; currSuit++){
            for(int currValue=0; currValue<=12; currValue++){
                if(currSuit==0){
                    if(currValue==0) {
                        newDeck[0][currValue]= new Card(Faces.ACE,Suit.HEARTS);
                    }else if(currValue==1){
                        newDeck[0][currValue]= new Card(Faces.TWO,Suit.HEARTS);
                    }else if(currValue==2){
                        newDeck[0][currValue]= new Card(Faces.THREE,Suit.HEARTS);
                    }else if(currValue==3){
                        newDeck[0][currValue]= new Card(Faces.FOUR,Suit.HEARTS);
                    }else if(currValue==4){
                        newDeck[0][currValue]= new Card(Faces.FIVE,Suit.HEARTS);
                    }else if(currValue==5){
                        newDeck[0][currValue]= new Card(Faces.SIX,Suit.HEARTS);
                    }else if(currValue==6){
                        newDeck[0][currValue]= new Card(Faces.SEVEN,Suit.HEARTS);
                    }else if(currValue==7){
                        newDeck[0][currValue]= new Card(Faces.EIGHT,Suit.HEARTS);
                    }else if(currValue==8){
                        newDeck[0][currValue]= new Card(Faces.NINE,Suit.HEARTS);
                    }else if(currValue==9){
                        newDeck[0][currValue]= new Card(Faces.TEN,Suit.HEARTS);
                    }else if(currValue==10){
                        newDeck[0][currValue]= new Card(Faces.JACK,Suit.HEARTS);
                    }else if(currValue==11){
                        newDeck[0][currValue]= new Card(Faces.QUEEN,Suit.HEARTS);
                    }else{
                        newDeck[0][currValue]= new Card(Faces.KING,Suit.HEARTS);
                    }
                }else if(currSuit==1){
                    if(currValue==0) {
                        newDeck[1][currValue]= new Card(Faces.ACE,Suit.SPADES);
                    }else if(currValue==1){
                        newDeck[1][currValue]= new Card(Faces.TWO,Suit.SPADES);
                    }else if(currValue==2){
                        newDeck[1][currValue]= new Card(Faces.THREE,Suit.SPADES);
                    }else if(currValue==3){
                        newDeck[1][currValue]= new Card(Faces.FOUR,Suit.SPADES);
                    }else if(currValue==4){
                        newDeck[1][currValue]= new Card(Faces.FIVE,Suit.SPADES);
                    }else if(currValue==5){
                        newDeck[1][currValue]= new Card(Faces.SIX,Suit.SPADES);
                    }else if(currValue==6){
                        newDeck[1][currValue]= new Card(Faces.SEVEN,Suit.SPADES);
                    }else if(currValue==7){
                        newDeck[1][currValue]= new Card(Faces.EIGHT,Suit.SPADES);
                    }else if(currValue==8){
                        newDeck[1][currValue]= new Card(Faces.NINE,Suit.SPADES);
                    }else if(currValue==9){
                        newDeck[1][currValue]= new Card(Faces.TEN,Suit.SPADES);
                    }else if(currValue==10){
                        newDeck[1][currValue]= new Card(Faces.JACK,Suit.SPADES);
                    }else if(currValue==11){
                        newDeck[1][currValue]= new Card(Faces.QUEEN,Suit.SPADES);
                    }else{
                        newDeck[1][currValue]= new Card(Faces.KING,Suit.SPADES);
                    }

                }else if(currSuit==2){
                    if(currValue==0) {
                        newDeck[2][currValue]= new Card(Faces.ACE,Suit.CLUBS);
                    }else if(currValue==1){
                        newDeck[2][currValue]= new Card(Faces.TWO,Suit.CLUBS);
                    }else if(currValue==2){
                        newDeck[2][currValue]= new Card(Faces.THREE,Suit.CLUBS);
                    }else if(currValue==3){
                        newDeck[2][currValue]= new Card(Faces.FOUR,Suit.CLUBS);
                    }else if(currValue==4){
                        newDeck[2][currValue]= new Card(Faces.FIVE,Suit.CLUBS);
                    }else if(currValue==5){
                        newDeck[2][currValue]= new Card(Faces.SIX,Suit.CLUBS);
                    }else if(currValue==6){
                        newDeck[2][currValue]= new Card(Faces.SEVEN,Suit.CLUBS);
                    }else if(currValue==7){
                        newDeck[2][currValue]= new Card(Faces.EIGHT,Suit.CLUBS);
                    }else if(currValue==8){
                        newDeck[2][currValue]= new Card(Faces.NINE,Suit.CLUBS);
                    }else if(currValue==9){
                        newDeck[2][currValue]= new Card(Faces.TEN,Suit.CLUBS);
                    }else if(currValue==10){
                        newDeck[2][currValue]= new Card(Faces.JACK,Suit.CLUBS);
                    }else if(currValue==11){
                        newDeck[2][currValue]= new Card(Faces.QUEEN,Suit.CLUBS);
                    }else{
                        newDeck[2][currValue]= new Card(Faces.KING,Suit.CLUBS);
                    }

                }else{
                    if(currValue==0) {
                        newDeck[3][currValue]= new Card(Faces.ACE,Suit.DIAMONDS);
                    }else if(currValue==1){
                        newDeck[3][currValue]= new Card(Faces.TWO,Suit.DIAMONDS);
                    }else if(currValue==2){
                        newDeck[3][currValue]= new Card(Faces.THREE,Suit.DIAMONDS);
                    }else if(currValue==3){
                        newDeck[3][currValue]= new Card(Faces.FOUR,Suit.DIAMONDS);
                    }else if(currValue==4){
                        newDeck[3][currValue]= new Card(Faces.FIVE,Suit.DIAMONDS);
                    }else if(currValue==5){
                        newDeck[3][currValue]= new Card(Faces.SIX,Suit.DIAMONDS);
                    }else if(currValue==6){
                        newDeck[3][currValue]= new Card(Faces.SEVEN,Suit.DIAMONDS);
                    }else if(currValue==7){
                        newDeck[3][currValue]= new Card(Faces.EIGHT,Suit.DIAMONDS);
                    }else if(currValue==8){
                        newDeck[3][currValue]= new Card(Faces.NINE,Suit.DIAMONDS);
                    }else if(currValue==9){
                        newDeck[3][currValue]= new Card(Faces.TEN,Suit.DIAMONDS);
                    }else if(currValue==10){
                        newDeck[3][currValue]= new Card(Faces.JACK,Suit.DIAMONDS);
                    }else if(currValue==11){
                        newDeck[3][currValue]= new Card(Faces.QUEEN,Suit.DIAMONDS);
                    }else{
                        newDeck[3][currValue]= new Card(Faces.KING,Suit.DIAMONDS);
                    }
                }
            }
        }
        //deck = newDeck;
    }

}
