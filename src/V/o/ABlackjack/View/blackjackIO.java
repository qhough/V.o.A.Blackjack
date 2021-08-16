package V.o.ABlackjack.View;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class blackjackIO {
    private static final BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

    public static String promptForString(String bigPrompt){
        while(true) {
            System.out.println(bigPrompt);
            String bigInput = "";
            try {
                bigInput = consoleIn.readLine();
                return bigInput;
            } catch (Exception ex) {
                System.err.println("Input cannot be null or empty; you entered '" + bigInput + "'");
            }
        }
    }

    public static String promptForStringChoice(String bigPrompt, String ChoiceOne,String ChoiceTwo){
        while(true) {
            System.out.println(bigPrompt);
            String bigInput = "";
            try {
                bigInput = consoleIn.readLine();
                if(bigInput.equalsIgnoreCase(ChoiceOne)|| bigInput.equalsIgnoreCase(ChoiceTwo)) {
                    return bigInput;
                }else{
                    System.out.println("You can only answer with "+ChoiceOne + " or "+ChoiceTwo);
                }
            } catch (Exception ex) {
                System.err.println("Input cannot be null or empty; you entered '" + bigInput + "'");
            }
        }
    }

    public static int promptForInt(int min, int max){
        do {

            try {
                String rawInput = consoleIn.readLine();
                int input = Integer.parseInt(rawInput);
                if(input < min || input > max) {
                    throw new IllegalArgumentException(
                            "input must be between " + min + " and " + max);
                }
                return input;
            } catch (NumberFormatException ex) {
                System.err.println("You must enter a valid integer.");
                System.err.println("Please try again.");
            } catch (Exception ex) {
                System.err.println(
                        "You have to enter an integer between " + min + " and " + max + ".");
                System.err.println("Please try again.");
            }
        } while(true);
    }

    public static void writeTextToFile(String filePath, String text, String date, boolean append) {
        //try with resources
        try {
            FileWriter writer = new FileWriter(filePath, append);
            writer.write( text + "-" + date +"\n");
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static String timeStamp(){
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return dateTimeFormatter.format(localDate);
    }
}
