package V.o.ABlackjack.Models;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    int total;
    boolean isBusted;
    private ArrayList<Card> hand = new ArrayList<>();
    private String name;
    private int aceCount;

    public int getAceCount() {
        return aceCount;
    }

    public void setAceCount(int aceCount) {
        this.aceCount = aceCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void checkBusted(Player x) {
        int total = 0;
            for (Card card : x.getHand()) {
                total += card.getValue();
            }
            x.setTotal(total);
            if (total >= 22) {
                    int i = 0;
                    for (Card c: x.getHand()) {
                        if(c.getValue() == 11 && total>= 22 ){
                            Suit suit = x.getHand().get(i).getSuit();
                            x.getHand().set(i, new Card(Faces.ACE, suit));
                            total =0;
                            for (Card card : x.getHand()) {
                                total += card.getValue();
                            }
                        }
                        i++;
                    }
                    x.setTotal(total);
                }
                if(total>=22) {
                    x.setBusted(true);
                    x.setTotal(-1);
                    System.out.println(x.getName() + ", you have busted!");
                }
        }
    }
