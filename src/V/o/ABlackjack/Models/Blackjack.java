package V.o.ABlackjack.Models;

import V.o.ABlackjack.View.blackjackIO;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Blackjack {
    private static final Deck deck = new Deck();
    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Player> winners = new ArrayList<>();
    public static Random dealerChooser = new Random();
    public static ArrayList<File> Songs = new ArrayList<>();
    public static int currentSong = 0;
    static AudioInputStream audioStream;
    static Clip clip;

    public static void runBlackjack() {
        Deck.shuffleDeck();
        players.clear();
        System.out.println("How many people are playing? (1-4)");
        addSongs();
        int playerPlaying = blackjackIO.promptForInt(1, 4);
        startGame(playerPlaying);
        onHit();
        writeToLeaderBoards();

    }

    public static void runBlackjackSame() {
        Deck.shuffleDeck();
        for (Player x : players) {
            x.clearHand();
        }
        onHit();
        writeToLeaderBoards();
    }

    public static void addSongs() {
        Songs.add(new File("src/V/o/ABlackjack/Songs/James/Imagine Dragons - Natural.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/James/Martin O'Donnell - Halo Theme.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/James/Musiq - Love.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/James/Post Malone - Better now.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/James/Takayoshi Tanimoto - Dragon soul.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Quincy/Aya Nakamura - Djadja.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Quincy/Lucky Daye - Floods.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Quincy/Tora-i - Serial.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Quincy/Tora-i - Vein.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Quincy/Yuna - Invisible.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Izzy/-.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Izzy/Takayan - Desperately want a lover.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Izzy/Holy Frick - Tom tom.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Izzy/MIYAVI - Samurai 45.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Izzy/nujabes - battlecry.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Avantasia - Lost in Space.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Chalino Sanchez - Alma enamorada.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Chris/El Komander - Soy De Rancho.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Vicente Fernandez - Mujeres divinas.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Vicente Fernández - Por Tu Maldito Amor.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Elijah/again&again - nownow.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Elijah/Friday Night Plans - HONDA.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Elijah/Glass Animals - Black Mambo.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Elijah/Luidji - Gisèle Part 4.wav"));
        Songs.add(new File("src/V/o/ABlackjack/Songs/Elijah/Seycara - mint chocolate chip.wav"));
        Collections.shuffle(Songs);

        Songs.add(0, new File("src/V/o/ABlackjack/Songs/Kenny Rogers - The Gambler.wav"));

        try {
            audioStream = AudioSystem.getAudioInputStream(Songs.get(0));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(20);
        } catch (Exception e) {
            System.out.println("Elijah doesn't know how to code. Sorry.");
        }
    }

    public static Card getNextCard() {
        Card ph = deck.getDeck().get(0);
        deck.moveCardToBottom();
        return ph;
    }

    public static void startGame(int playerCount) {
        players.add(new Player());
        players.get(0).setName("Dealer");
        for (int i = 0; i < playerCount; i++) {

            String nameRequested = blackjackIO.promptForString("What would you like your name to be Player " + (i + 1) + " ? ");
            players.add(new Player());
            players.get(i + 1).setName(nameRequested);
        }
    }

    public static void onHit() {

        for (Player p : players) {
            boolean finished = false;
            p.getHand().add(getNextCard());
            p.getHand().add(getNextCard());
            p.checkBusted(p);
            while (p.isBusted() & !finished) {
                if (p != players.get(0)) {
                    System.out.println(p.getName() + " You Have : " + p.getHand().toString() + " Total:" + p.getTotal());
                    if (p != players.get(0)) {
                        System.out.println("The dealer has: " + players.get(0).getHand().get(0) + " as their first card.");
                    }
                    System.out.println(p.getName() + ": Would you like to hit or stand\n+)Hit \n0)Stand");
                    String choice = blackjackIO.promptForStringChoice("", "+", "0");
                    if (choice.equals("+")) {
                        p.getHand().add(getNextCard());
                        p.checkBusted(p);
                    } else {
                        finished = true;
                    }
                } else {
                    while (dealerChoice()) {
                        p.getHand().add(getNextCard());
                        p.checkBusted(p);
                    }
                    finished = true;
                }
            }
        }
        for (Player p : players) {
            int totalPlayer = 0;
            if (p.isBusted()) {
                for (Card card : p.getHand()) {
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
            return choice == 0;
        } else if (players.get(0).getTotal() > 17) {
            int choice = dealerChooser.nextInt(5);
            return choice == 0 || choice == 1;
        } else {
            return false;
        }
    }

    public static void checkWin() {
        for (Player p : players) {
            if (p != players.get(0) && p.isBusted()) {
                if (p.getTotal() > players.get(0).getTotal()) {
                    winners.add(p);
                    p.setTimesWon(p.getTimesWon() + 1);
                }
            }
        }
    }

    public static void writeToLeaderBoards() {
        StringBuilder winnersResults = new StringBuilder();
        int newDealerTotal = 0;
        for (int i = 0; i < players.get(0).getHand().size(); i++) {
            newDealerTotal += players.get(0).getHand().get(i).getValue();
        }
        System.out.println("The dealer has: " + newDealerTotal);
        if (winners.size() == 0) {
            System.out.println("You all suck");
        } else {
            winnersResults.append("Congratulations: ");
            int i = 0;
            for (Player winner : winners) {
                if (i == 0) {
                    winnersResults.append(winner.getName());
                    i++;
                } else {
                    winnersResults.append(", ").append(winner.getName());
                }
            }
            winnersResults.append("\n You have Won!!!!!!!");
            System.out.println(winnersResults);
        }

        String toContinue = blackjackIO.promptForStringChoice("Would you like to continue? (Y/N)", "Y", "N");
        if (toContinue.equalsIgnoreCase("Y")) {
            String playersChoice = blackjackIO.promptForStringChoice("Play with the same people? (Y/N)", "Y", "N");
            if (playersChoice.equalsIgnoreCase("Y")) {
                System.out.println("Starting over.");
                winners.clear();
                runBlackjackSame();
            } else {
                if (winners.size() != 0) {
                    write();
                }
                System.out.println("Starting over.");
                winners.clear();
                runBlackjack();
            }
        } else {
            if (winners.size() != 0) {
                write();
            }
            System.out.println("Goodbye.");
        }
    }

    public static void write() {
        StringBuilder winnersResultsWrite = new StringBuilder();
        winnersResultsWrite.append("Congratulations: ");
        for (Player winner : winners) {
            String timeChoice;
            if (winner.getTimesWon() == 1) {
                timeChoice = "time";
            } else {
                timeChoice = "times";

            }
            winnersResultsWrite.append(winner.getName()).append(", You won ").append(winner.getTimesWon()).append(" ").append(timeChoice).append(", ");
        }
        blackjackIO.writeTextToFile("Leaderboards.txt", winnersResultsWrite.toString(), blackjackIO.timeStamp(), true);

    }

    public static void nextSong() {
        if (currentSong == 26) {
            currentSong = 0;
        } else {
            currentSong += 1;
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(Songs.get(currentSong));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(20);
        } catch (Exception e) {
            System.out.println("Elijah still doesn't know how to code. sorry");
        }
    }

    public static void prevSong() {
        if (currentSong == 0) {
            currentSong = 26;
        } else {
            currentSong -= 1;
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(Songs.get(currentSong));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(20);
        } catch (Exception e) {
            System.out.println("Elijah still doesn't know how to code. sorry");
        }
    }


}
