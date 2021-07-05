package com.ironhack.game.play;

import com.ironhack.game.party.CreatePartyManually;


import com.ironhack.game.party.CreatePartyRandomly;

import com.ironhack.game.party.ImportParty;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Menu {

    public static void menuControl(int menuStep) throws FileNotFoundException {
        boolean menuControl = true;
        while(menuControl) {

            //----INNER CONDITION INSIDE LOOP TO SET GAME
            //----GOES FORWARD EXCEPT IF USER ENTERS BACK OR QUIT
            if(menuStep == 1) {
                playMode();
                menuStep++; // After each step, method continues to ask user to press enter, the loops back
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

            //---- CONTINUES HERE AFTER EACH IF STATEMENT
            System.out.println("Press enter to continue");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
                // If user enters: quit - closes program / back - go back to last step of game set-up
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

    public static void playMode() {
        System.out.println("How do you want to play?");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Player vs Player                         │");
        System.out.println("│[2] Player vs Computer                       │");
        System.out.println("│[3] Computer vs Computer                     │");
        System.out.println("┖---------------------------------------------┚");
        Scanner playModeScanner = new Scanner(System.in);
        // while loop to only accept valid values
        while(true){
            String userModeSelection = playModeScanner.nextLine();

            if(     userModeSelection.equals("1") || // Player vs Player
                    userModeSelection.equals("2") || // Player vs Computer
                    userModeSelection.equals("3"))   // Computer vs Computer
            {
            GameSet.setPlayMode(Integer.parseInt(userModeSelection));
            }
            break;
        }
    }

    public static void setPlayers() {
        Scanner setNameScanner = new Scanner(System.in);
        switch (GameSet.getPlayMode()) {
            case 1:
                System.out.println("Enter Player 1 name:");
                String playerOneName = setNameScanner.nextLine();
                GameSet.setPlayerOne(new Player(playerOneName, true));
                System.out.println("Enter Player 2 name:");
                String playerTwoName = setNameScanner.nextLine();
                GameSet.setPlayerTwo(new Player(playerTwoName, true));
                break;

            case 2:
                System.out.println("Enter Player 1 name:");
                String playerOneName2 = setNameScanner.nextLine();
                GameSet.setPlayerOne(new Player(playerOneName2, true));
                GameSet.setPlayerTwo(new Player("ComputerOne", false));
                // Initialize player2 as random computer player
                break;

            case 3:
                GameSet.setPlayerOne(new Player("ComputerOne", false));
                GameSet.setPlayerTwo(new Player("ComputerTwo", false));
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
                createParty(GameSet.getPlayerTwo());
                break;
            default:
                createParty(GameSet.getPlayerOne());
                createParty(GameSet.getPlayerTwo());
        }
    }
    // Called by createPartyByPlayMode() BETTER NAME CREATEPARTYHELPER
    public static void createParty(Player player) throws FileNotFoundException {
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
