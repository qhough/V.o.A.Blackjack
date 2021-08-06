package V.o.ABlackjack.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class blackjackIO {
    private  BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

    public String promptForString(String bigprompt) throws IOException {
        while(true) {
            System.out.println(bigprompt);
            String biginput = consoleIn.readLine();
            try {
                return biginput;
            } catch (IllegalArgumentException ex) {
                System.err.println("Input cannot be null or empty; you entered '" + biginput + "'");
            }
        }
    }
    public int promptForInt(int min, int max) throws IOException {
        do {
            String rawInput = consoleIn.readLine();
            try {
                int input = Integer.parseInt(rawInput);
                if(input < min || input > max) {
                    throw new IllegalArgumentException(
                            "input must be between " + min + " and " + max);
                }
                return input;
            } catch (NumberFormatException ex) {
                System.err.println("You must enter a valid integer.");
                System.err.println("Please try again.");
            } catch (IllegalArgumentException ex) {
                System.err.println(
                        "You have to enter an integer between " + min + " and " + max + ".");
                System.err.println("Please try again.");
            }
        } while(true);
    }
}
