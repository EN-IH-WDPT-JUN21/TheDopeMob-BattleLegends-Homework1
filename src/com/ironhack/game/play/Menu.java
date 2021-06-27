package com.ironhack.game.play;

import com.ironhack.game.party.ImportParty;

import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Menu {

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
                System.out.println("Create party manually");
                break;
            case 2:
                ImportParty.create(player);
                break;
            case 3:
                System.out.println("Random party");
                break;
        }
    }
}
