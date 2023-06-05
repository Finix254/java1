import java.util.*;

public class qn2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("How many dice do you want to roll? ");
        int numberOfDice = scanner.nextInt();

        List<Integer> diceValues = roll(numberOfDice, rnd);
        System.out.println("Dice values: " + diceValues);

        int total = diceTotal(diceValues);
        System.out.println("Total: " + total);

        boolean allSame = allSameValue(diceValues);
        System.out.println("All dice are the same value: " + allSame);

        boolean rollAgain = yesNoInput(scanner, "Roll again? (yes/no) ");
        while (rollAgain) {
            diceValues = roll(numberOfDice, rnd);
            System.out.println("Dice values: " + diceValues);

            total = diceTotal(diceValues);
            System.out.println("Total: " + total);

            allSame = allSameValue(diceValues);
            System.out.println("All dice are the same value: " + allSame);

            rollAgain = yesNoInput(scanner, "Roll again? (yes/no) ");
        }
    }

    public static List<Integer> roll(int numberOfDice, Random rnd) {
        List<Integer> diceValues = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            int roll = rnd.nextInt(6) + 1;
            diceValues.add(roll);
        }
        return diceValues;
    }

    public static int diceTotal(List<Integer> diceValues) {
        int total = 0;
        for (int dice : diceValues) {
            total += dice;
        }
        return total;
    }

    public static boolean allSameValue(List<Integer> diceValues) {
        int firstDice = diceValues.get(0);
        for (int dice : diceValues) {
            if (dice != firstDice) {
                return false;
            }
        }
        return true;
    }

    public static boolean yesNoInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
