package com.ironhack.game.play;

import com.ironhack.game.party.CreatePartyManually;
import com.ironhack.game.party.CreatePartyRandomly;
import com.ironhack.game.party.ImportParty;

import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Menu {
                            //----UTILITY FOR GAME SETTING----//
    public static void menuControl(int menuStep) throws FileNotFoundException {
        boolean menuControl = true; // to step out of WHILE before game is set

        while(menuControl) { // Logic to call game setting functionality
            if(menuStep == 1) {
                playMode();
                menuStep++;
            } else if (menuStep == 2) {
                setPlayers();
                menuStep++;
            } else if (menuStep == 3) {
                createPartyByPlayMode();
                menuStep++;
            } else if (menuStep == 4) {
                System.out.println("!!!BATTLE!!!");
                menuControl = false;
            }
            //----After each IF statement it continues here
            //----Possible inputs to navigate steps: ["", "quit", "back"] + ENTER
            System.out.println("CONTINUE: press ENTER\nBACK: write 'back' + ENTER\nQUIT: write 'quit' + ENTER");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
                // If user enters:
                                 //quit - closes program
                                // back - go back to last step of game set-up
            switch (userInput) {
                case "quit":
                    System.exit(0);
                    menuControl = false;
                    break;
                case "back":
                    menuStep--;
                    System.out.println("Go to previous stage");
                    break;
            }

        }
    }
    //---- Set type of players: humans, computer or mix
    private static void playMode() {
        System.out.println("How do you want to play?");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Player vs Player                         │");
        System.out.println("│[2] Player vs Computer                       │");
        System.out.println("│[3] Computer vs Computer                     │");
        System.out.println("┖---------------------------------------------┚");

        Scanner scanner = new Scanner(System.in);

        int userModeSelection;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter [1], [2] or [3].\n");
                scanner.next();
            }
            userModeSelection = scanner.nextInt();

            if (userModeSelection < 1 || userModeSelection > 3)
                System.out.println("Please enter [1], [2] or [3].\n");

        } while (userModeSelection < 1 || userModeSelection > 3);

        GameSet.setPlayMode(userModeSelection);

    }
    //---- Set human players name and instantiate Players
    private static void setPlayers() {
        Scanner setNameScanner = new Scanner(System.in);
        String playerOneName;
        switch (GameSet.getPlayMode()) {
            case 1: // human vs human
                System.out.println("Enter Player 1 name:");
                playerOneName = setNameScanner.next();
                GameSet.setPlayerOne(new Player(playerOneName,true));
                System.out.println("Enter Player 2 name:");
                String playerTwoName = setNameScanner.next();
                GameSet.setPlayerTwo(new Player(playerTwoName,true));
                break;

            case 2: // human vs computer
                System.out.println("Enter Player 1 name:");
                playerOneName = setNameScanner.next();
                GameSet.setPlayerOne(new Player(playerOneName, true));
                GameSet.setPlayerTwo(new Player("Computer", false));
                break;

            case 3: // computer vs computer
                GameSet.setPlayerOne(new Player("ComputerOne", false));
                GameSet.setPlayerTwo(new Player("ComputerTwo", false));
                break;
        }
    }

    //---- Calls createPartyHelper() according playMode selection
    //---- createPartyHelper() prompts human player to select party creation mode
    private static void createPartyByPlayMode() throws FileNotFoundException {

        switch (GameSet.getPlayMode()) {
            case 1:
                createPartyHelper(GameSet.getPlayerOne());
                createPartyHelper(GameSet.getPlayerTwo());
                break;
            case 2:
                createPartyHelper(GameSet.getPlayerOne());
                CreatePartyRandomly partyRandomly = new CreatePartyRandomly();
                partyRandomly.createPartyRandomly(GameSet.getPlayerTwo());
                break;
            case 3:
                CreatePartyRandomly partyRandomly1 = new CreatePartyRandomly();
                partyRandomly1.createPartyRandomly(GameSet.getPlayerOne());
                CreatePartyRandomly partyRandomly2 = new CreatePartyRandomly();
                partyRandomly2.createPartyRandomly(GameSet.getPlayerTwo());
        }
    }
    // Helper method to createPartyByPlayMode()
    private static void createPartyHelper(Player player) throws FileNotFoundException {
        System.out.println(player.getName() + ", create your party!");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Manually                                 │");
        System.out.println("│[2] Import                                   │");
        System.out.println("│[3] Randomly                                 │");
        System.out.println("┖---------------------------------------------┚");
        Scanner scanner = new Scanner(System.in);
        int userPartyOption;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter [1], [2] or [3].\n");
                scanner.next();
            }
            userPartyOption = scanner.nextInt();

            if (userPartyOption < 1 || userPartyOption > 3)
                System.out.println("Please enter [1], [2] or [3].\n");

        } while (userPartyOption < 1 || userPartyOption > 3);

        switch (userPartyOption) {
            case 1:
                CreatePartyManually partyCreation = new CreatePartyManually();
                partyCreation.createPartyManually(player);
                break;
            case 2:
                ImportParty.create(player);
                break;
            case 3:
                CreatePartyRandomly partyRandomly = new CreatePartyRandomly();
                partyRandomly.createPartyRandomly(player);
                break;
        }
    }
}
