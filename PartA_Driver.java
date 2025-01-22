/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Scanner;
import java.util.Random;

public class PartA_Driver {

    public static void main(String[] args) {

        int difficulty = 1;
        String colors[] = { "Red", "Blue", "Yellow", "Green" };
        ArrayList<String> colorSequence = new ArrayList<String>();
        ArrayList<String> userInput = new ArrayList<String>();
        Scanner kb = new Scanner(System.in);
        System.out.println("Let's Play Simon!\n");
        boolean isRunning = false;
        do {
            ArrayList<String> tempColors = generateColorSequence(difficulty, colors);
            for (String color : tempColors) {
                colorSequence.add(color);
            }

            for (int i = 0; i < tempColors.size(); i++) {
                System.out.print(tempColors.get(i));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                for (int j = 0; j < tempColors.get(i).length(); j++) {
                    System.out.print("\b");
                }
                for (int j = 0; j < tempColors.get(i).length(); j++) {
                    System.out.print(" ");
                }
                System.out.println();

            }
            System.out.println("Enter the color sequence: ");
            String[] uResponse = kb.nextLine().split(" ");
            for (int i = 0; i < uResponse.length; i++) {
                userInput.add(uResponse[i]);
            }
            isRunning = userInput.equals(colorSequence);
            if (isRunning) {
                System.out.println("Correct! Your Current Score is " + difficulty + "\n");
                difficulty++;
            }

        } while (isRunning);
        kb.close();
        System.out.println("Game Over! Your score is " + difficulty);

    }

    public static ArrayList<String> generateColorSequence(int difficulty, String[] colors) {
        Random rand = new Random();
        ArrayList<String> colorSequence = new ArrayList<String>();
        for (int i = 0; i < difficulty; i++) {
            int randomIndex = rand.nextInt(colors.length);
            colorSequence.add(colors[randomIndex]);
        }
        return colorSequence;

    }
}
