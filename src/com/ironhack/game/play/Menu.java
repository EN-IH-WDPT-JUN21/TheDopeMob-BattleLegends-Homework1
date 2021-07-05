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
                    System.out.println("Quit game");
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

        Scanner playModeScanner = new Scanner(System.in);
        while(true){ // only accept valid values
            String userModeSelection = playModeScanner.nextLine();

            if(     userModeSelection.equals("1") || // Player vs Player
                    userModeSelection.equals("2") || // Player vs Computer
                    userModeSelection.equals("3"))   // Computer vs Computer
            {
            GameSet.setPlayMode(Integer.parseInt(userModeSelection));
            break;
            } else { // Ask again if enter an invalid option
                System.out.println("That's not a valid option!!!\n");
                System.out.println("How do you want to play?");
                System.out.println("┎---------------------------------------------┒");
                System.out.println("│[1] Player vs Player                         │");
                System.out.println("│[2] Player vs Computer                       │");
                System.out.println("│[3] Computer vs Computer                     │");
                System.out.println("┖---------------------------------------------┚");
            }
        }
    }
    //---- Set human players name and instantiate Players
    private static void setPlayers() {
        Scanner setNameScanner = new Scanner(System.in);
        String playerOneName;
        switch (GameSet.getPlayMode()) {
            case 1: // human vs human
                System.out.println("Enter Player 1 name:");
                playerOneName = setNameScanner.nextLine();
                GameSet.setPlayerOne(new Player(playerOneName));
                System.out.println("Enter Player 2 name:");
                String playerTwoName = setNameScanner.nextLine();
                GameSet.setPlayerTwo(new Player(playerTwoName));
                break;

            case 2: // human vs computer
                System.out.println("Enter Player 1 name:");
                playerOneName = setNameScanner.nextLine();
                GameSet.setPlayerOne(new Player(playerOneName));
                GameSet.setPlayerTwo(new Player("ComputerOne"));
                break;

            case 3: // computer vs computer
                GameSet.setPlayerOne(new Player("ComputerOne"));
                GameSet.setPlayerTwo(new Player("ComputerTwo"));
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
        Scanner createPartyScanner = new Scanner(System.in);
        int userPartyOption;
        while(true) { // To ensure user inputs a valid choice
            String partyOption = createPartyScanner.nextLine(); // COULD USE INT AND LESS CODE

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
