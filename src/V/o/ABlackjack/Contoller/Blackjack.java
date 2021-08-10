package V.o.ABlackjack;

import V.o.ABlackjack.Models.Card;
import V.o.ABlackjack.Models.Deck;
import V.o.ABlackjack.Models.Player;
import java.util.ArrayList;

public class Blackjack {
    private final Deck deck =  new Deck();
    public ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Player> winners = new ArrayList<>();

    public Blackjack(){
        Deck.shuffleDeck();
    }

    public Card getNextCard(){
        Card ph = deck.getDeck().get(0);
        deck.moveCardToBottom();
        return ph;
    }

    public void startGame(int playerCount){
        players.add(new Player());
        for(int i=0; i<playerCount; i++) {
            players.add(new Player());
        }
    }
    public int promptHit(){
        return 1;
    }

    public void onHit(){
        int i = 0;
        for(Player p: players){
            i++;
            boolean finished = false;
            while(!p.isBusted() & !finished){
                int choice = promptHit();
                if(choice == 0){
                    p.getHand().add(getNextCard());
                    p.checkBusted(p);
                }else{
                    finished = true;
                }
            }
        }
        for(Player p: players){
            int totalPlayer = 0;
            if(!p.isBusted()){
                for(Card card : p.getHand()){
                    totalPlayer += card.getValue();
                }
                p.setTotal(totalPlayer);
            }
        }
        checkWin();
    }
    public void checkWin(){
        for(Player p: players){
            if(p != players.get(0) & !p.isBusted()){
                if(p.getTotal() <= players.get(0).getTotal()){

                }else{
                    winners.add(p);
                }
            }
        }
    }

}