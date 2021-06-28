package com.ironhack.game.play;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Start.welcome(); // Initial message and signal for game set-up;
        Menu.menuControl(1); // Start game set-up step by step
        System.out.println("Battle functionality here");

        // Repeat until one of the players (or both) have no characters left
        System.out.println("The winner is ...");
        System.out.println("Play again?");


    }
}
