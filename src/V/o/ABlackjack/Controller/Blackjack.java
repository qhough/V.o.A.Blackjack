package V.o.ABlackjack.Controller;

import V.o.ABlackjack.Models.Card;
import V.o.ABlackjack.Models.Deck;
import V.o.ABlackjack.Models.Player;
import V.o.ABlackjack.View.blackjackIO;


import java.util.ArrayList;
import java.util.Random;

public class Blackjack {
    private static final Deck deck =  new Deck();
    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Player> winners = new ArrayList<>();
    public static
    Random dealerChooser = new Random();

    public static void runBlackjack() {
        Deck.shuffleDeck();
        players.clear();
        System.out.println("How many people are playing?");
        int playerPlaying = blackjackIO.promptForInt(1,4);
        startGame(playerPlaying);
        onHit();
        writeToLeaderBorads();

    }

    public static void runBlackjackSame() {
        Deck.shuffleDeck();
        for(Player x: players){
            x.clearHand();
        }
        onHit();
        writeToLeaderBorads();
    }

    public static Card getNextCard(){
        Card ph = deck.getDeck().get(0);
        deck.moveCardToBottom();
        return ph;
    }

    public static void startGame(int playerCount){
        players.add(new Player());
        players.get(0).setName("Dealer");
        for(int i=0; i<playerCount; i++) {

            String nameRequested = blackjackIO.promptForString("What would you like your name to be? ");
            players.add(new Player());
            players.get(i+1).setName(nameRequested);
        }
    }

    public static void onHit()  {

        for(Player p: players){
            boolean finished = false;
            p.getHand().add(getNextCard());
            p.getHand().add(getNextCard());
            p.checkBusted(p);
            while(!p.isBusted() & !finished){
                if(p != players.get(0)) {
                    System.out.println(p.getName() + " You Have : " + p.getHand().toString() + " Total:" + p.getTotal());
                    if (p != players.get(0)) {
                        System.out.println("The dealer has: " + players.get(0).getHand().get(0) + " as their first card.");
                    }
                    System.out.println(p.getName() + ": Would you like to hit or stand\n 0)Hit \n 1)Stand");
                    int choice = blackjackIO.promptForInt(0, 1);
                    if (choice == 0) {
                        p.getHand().add(getNextCard());
                        p.checkBusted(p);
                    } else {
                        finished = true;
                    }
                }else{
                    while(dealerChoice()){
                        p.getHand().add(getNextCard());
                        p.checkBusted(p);
                    }
                    finished =true;
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

    public static boolean dealerChoice() {
        if (players.get(0).getTotal() > -1 && players.get(0).getTotal() < 12) {
            return true;
        } else if (players.get(0).getTotal() < 14) {
            int choice = dealerChooser.nextInt(2);
            System.out.println(choice);
            return choice == 0;
        } else if (players.get(0).getTotal() > 17) {
            int choice = dealerChooser.nextInt(5);
            return choice == 0 || choice == 1;
        } else{
            return false;
        }
    }

    public static void checkWin(){
        for(Player p: players){
            if(p != players.get(0) && !p.isBusted()){
                if(p.getTotal() > players.get(0).getTotal()){
                    winners.add(p);
                    p.setTimesWon(p.getTimesWon()+1);
                }
            }
        }
    }

    public static void writeToLeaderBorads(){
        StringBuilder winnersResults = new StringBuilder();
        System.out.println("The dealer has: "+ players.get(0).getTotal());
        if(winners.size()== 0){
            System.out.println("You all suck");
        }else{
            winnersResults.append("Congratulations: ");
            int i = 0;
            for (Player winner: winners) {
                if(i == 0){
                    winnersResults.append(winner.getName());

                    i++;
                }else{
                    winnersResults.append(", ").append(winner.getName());
                }
            }
            winnersResults.append("\n You have Won!!!!!!!");
            System.out.println(winnersResults.toString());
        }

        String toContinue = blackjackIO.promptForStringChoice("Would you like to continue? (Y/N)","Y","N");
        if(toContinue.equalsIgnoreCase("Y")){
            String playersChoice =blackjackIO.promptForStringChoice("Play with the same people? (Y/N)","Y", "N");
            if(playersChoice.equalsIgnoreCase("Y")){
                System.out.println("Starting over.");
                winners.clear();
                runBlackjackSame();
            }else{
                if(winners.size() != 0) {
                    write();
                }
                System.out.println("Starting over.");
                winners.clear();
                runBlackjack();
            }
        }else{
            if(winners.size() != 0) {
                write();
            }
            System.out.println("Goodbye.");
        }
    }

    public static void write(){
        StringBuilder winnersResultsWrite = new StringBuilder();
        winnersResultsWrite.append("Congratulations: ");
        for (Player winner:winners) {
            String timeChoice = "";
            if (winner.getTimesWon() == 1) {
                timeChoice = "time";
            } else {
                timeChoice = "times";

            }
            winnersResultsWrite.append(winner.getName()).append(", You won ").append(winner.getTimesWon()).append(" ").append(timeChoice).append(", ");
        }
        blackjackIO.writeTextToFile("Leaderboards.txt", winnersResultsWrite.toString(), blackjackIO.timeStamp(),true );

    }
}
