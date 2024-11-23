package com.nit.ExceptionHandling;
import java.util.Scanner;

class InvalidNumberOfPlayersException extends Exception {
    public InvalidNumberOfPlayersException(String message) {
        super(message);
    }
}

class EmptyPlayerNameException extends Exception {
    public EmptyPlayerNameException(String message) {
        super(message);
    }
}

public class Cricket {
    private int numberOfPlayers;
    private String[] playerNames;

    public Cricket(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = new String[numberOfPlayers];
    }

    public void selectPlayers(Scanner sc) throws InvalidNumberOfPlayersException, EmptyPlayerNameException {
        if (numberOfPlayers <= 0) {
            throw new InvalidNumberOfPlayersException("Number of players should be greater than 0.");
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + "'s name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) {
                throw new EmptyPlayerNameException("Player name cannot be empty.");
            }
            playerNames[i] = name;
        }
    }

    public void displaySelectedPlayers() {
        System.out.println("\nSelected Players for the T20 match:");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println((i + 1) + ". " + playerNames[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the number of players for T20:");
            int numberOfPlayers = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Cricket c = new Cricket(numberOfPlayers);
            c.selectPlayers(sc);  // Pass the Scanner object instead of a Cricket object
            c.displaySelectedPlayers();
        } catch (InvalidNumberOfPlayersException | EmptyPlayerNameException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
