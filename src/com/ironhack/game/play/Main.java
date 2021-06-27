package com.ironhack.game.play;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Start.welcome(); // Initial message and signal for game set-up;
        Menu.playMode(); // User selects the playing mode: human/human, human/computer or computer/computer;
        Menu.setPlayers(); // Create players according to user choice;

        switch (GameSet.getPlayMode()) {
            case 1:
                Menu.createParty(GameSet.getPlayerOne()); // Create and store characters for playerOne;
                Menu.createParty(GameSet.getPlayerTwo()); // Create and store characters for playerTwo;
                break;
            case 2:
                Menu.createParty(GameSet.getPlayerOne());
                break;
            default:
        }

        System.out.println(GameSet.getPlayerOne());
        System.out.println(GameSet.getPlayerTwo());

    }
}
