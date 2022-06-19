import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        try (Scanner input = new Scanner(System.in)) {
            String command;
            boolean exit = false;
            System.out.println("Please enter a command (enter q to exit): ");
            while (!exit) {
                command = input.nextLine();
                String[] commandSplit = command.split(" ");

                String code;
                String name;
                String inputAmount;

                switch (commandSplit[0].toLowerCase()) {
                    case "q" -> exit = true;
                    case "create" -> {
                        code = commandSplit[1];
                        name = commandSplit[2];
                        bank.createAccount(name, code);
                    }
                    case "deposit" -> {
                        code = commandSplit[1];
                        inputAmount = commandSplit[2];
                        bank.depositAmount(code, inputAmount);
                    }
                    case "withdraw" -> {
                        code = commandSplit[1];
                        inputAmount = commandSplit[2];
                        bank.withdrawAmount(code, inputAmount);
                    }
                    case "balance" -> {
                        code = commandSplit[1];
                        bank.balance(code);
                    }
                    default -> System.out.println("Invalid command!");
                }
            }
            throw new IOException("Thank you for using our service.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}