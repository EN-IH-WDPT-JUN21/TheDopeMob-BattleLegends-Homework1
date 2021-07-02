package com.ironhack.game.play;

import com.ironhack.game.party.ImportParty;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

public abstract class Menu {

    public static void menuControl(int menuStep) throws FileNotFoundException {
        boolean menuControl = true;
        while(menuControl) { // Allows for game setting, stepping back or quiting almost at any moment
                             // Will come out of loop once game setting is finished or by user input: quit
            if(menuStep == 1) {
                playMode();
                menuStep++;
            } else if (menuStep == 2) {
                setPlayers();
                menuStep++;
            } else if (menuStep == 3) {
                Menu.createPartyByPlayMode();
                menuStep++;
            } else if (menuStep == 4) {
                System.out.println("!!!BATTLE!!!");
                menuControl = false;
            }
            System.out.println("Press enter to continue");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "quit":
                    System.out.println("Quit game");
                    menuControl = false;
                    break;
                case "back":
                    menuStep--;
                    System.out.println("Go to previous stage");
                    break;
                default:
            }
        }
    }

    public static void playMode() {
        System.out.println("How do you want to play?\n1) Player vs Player\n2) Player vs Computer\n3) Computer vs Computer");
        Scanner playModeScanner = new Scanner(System.in);
        // while loop to only accept valid values
        while(true){
            String userModeSelection = playModeScanner.nextLine();

            if(     userModeSelection.equals("1") || // Player vs Player
                    userModeSelection.equals("2") || // Player vs Computer
                    userModeSelection.equals("3"))   // Computer vs Computer
            {
            GameSet.setPlayMode(Integer.parseInt(userModeSelection));
            break;
            }
        }
    }

    public static void setPlayers() {
        Scanner setNameScanner = new Scanner(System.in);
        switch (GameSet.getPlayMode()) {
            case 1:
                System.out.println("Enter player 1 name:");
                String playerOneName = setNameScanner.nextLine();
                GameSet.setPlayerOne(new Player(playerOneName));
                System.out.println("Enter player 2 name:");
                String playerTwoName = setNameScanner.nextLine();
                GameSet.setPlayerTwo(new Player(playerTwoName));
                break;

            case 2:
                System.out.println("Enter player 1 name:");
                String playerOneName2 = setNameScanner.nextLine();
                GameSet.setPlayerOne(new Player(playerOneName2));
                // Initialize player2 as random computer player
                break;

            case 3:
                System.out.println("Enjoy the battle!");
                // Initialize player1 and player2 as random computer players
                break;
        }


    }
    // Calls createParty according to case
    public static void createPartyByPlayMode() throws FileNotFoundException {
        switch (GameSet.getPlayMode()) {
            case 1:
                createParty(GameSet.getPlayerOne());
                createParty(GameSet.getPlayerTwo());
                break;
            case 2:
                createParty(GameSet.getPlayerOne());
                break;
            default:
                System.out.println("Create two random parties...");
        }
    }
    // Called by createPartyByPlayMode()
    public static void createParty(Player player) throws FileNotFoundException {
        System.out.println(player.getName() + ", create your party!\n1) Manually\n2) Import\n3) Random");
        Scanner createPartyScanner = new Scanner(System.in);
        int userPartyOption;
        while(true) { // To ensure user inputs a valid choice
            String partyOption = createPartyScanner.nextLine();

            if (partyOption.equals("1") ||
                    partyOption.equals("2") ||
                    partyOption.equals("3"))
            {
            userPartyOption = Integer.parseInt(partyOption);
            break;
            }
        }

        switch (userPartyOption) {
            case 1:
                System.out.println("Create party manually"); // Manual party should be called here
                break;
            case 2:
                ImportParty.create(player);
                break;
            case 3:
                System.out.println("Random party"); // Random party should be called here
                break;
        }
    }
}