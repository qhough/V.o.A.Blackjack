package V.o.ABlackjack.Models;

import java.util.ArrayList;

public class Player {
    private final String nickname;
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

}
