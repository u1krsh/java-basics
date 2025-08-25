import java.util.Random;

public class dice {
    public static void main(String[] args) {
        Random rand = new Random();
        int count = 0;

        while (true) {
            int x = rand.nextInt(1, 7); // Generates number between 1 and 6
            count++;

            if (x == 1) {
                System.out.println("-----\n" +
                        "|   |\n" +
                        "| o |\n" +
                        "|   |\n" +
                        "-----");
            } else if (x == 2) {
                System.out.println("-----\n" +
                        "|o  |\n" +
                        "|   |\n" +
                        "|  o|\n" +
                        "-----");
            } else if (x == 3) {
                System.out.println("-----\n" +
                        "|o  |\n" +
                        "| o |\n" +
                        "|  o|\n" +
                        "-----");
            } else if (x == 4) {
                System.out.println("-----\n" +
                        "|o o|\n" +
                        "|   |\n" +
                        "|o o|\n" +
                        "-----");
            } else if (x == 5) {
                System.out.println("-----\n" +
                        "|o o|\n" +
                        "| o |\n" +
                        "|o o|\n" +
                        "-----");
            } else if (x == 6) {
                System.out.println("-----\n" +
                        "|o o|\n" +
                        "|o o|\n" +
                        "|o o|\n" +
                        "-----");
                System.out.println("The dice rolled a 6 after " + count + " throws.");
                break;
            }
        }
    }
}
