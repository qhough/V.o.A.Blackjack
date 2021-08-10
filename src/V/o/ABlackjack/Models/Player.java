package V.o.ABlackjack.Models;

import java.util.ArrayList;

public class Player {
    private final String nickname;
    int total;
    boolean isBusted;
    private final ArrayList<Card> hand;


    public Player(String nickname, ArrayList<Card> hand) {
        this.nickname = nickname;
        this.hand = hand;
    }

    public String getNickname() {
        return nickname;
    }

    public void addCard(Card card){
        hand.add(card);
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isBusted() {
        return isBusted;
    }

    public void setBusted(boolean busted) {
        isBusted = busted;
    }
    public void checkBusted( Player x){
        int total=0;
        for(Card card: x.getHand()){
            total += card.getValue();
        }
        if(total >=22){
            x.setBusted(true);
        }
    }

}
