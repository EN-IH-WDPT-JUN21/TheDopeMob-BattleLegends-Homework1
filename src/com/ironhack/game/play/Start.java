package com.ironhack.game.play;

import java.util.Scanner;

public abstract class Start {

    public static void welcome() {
        System.out.println("DOPEMOB\nLEGENDS");
        System.out.println("Press ENTER to start");
        Scanner scanner = new Scanner(System.in); // No scanner.close() since it also closes System.in (necessary for program)
        // while loop to only move ahead if user presses enter without entering any values
        while(true){
            String enter = scanner.nextLine();
            if(enter.equals("")) {
                break;
            }
        }
        System.out.println("LET'S BATTLE!!!");
    }

}