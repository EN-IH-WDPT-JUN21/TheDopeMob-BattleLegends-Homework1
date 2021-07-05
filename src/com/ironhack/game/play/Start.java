package com.ironhack.game.play;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//---GAME START SCREEN
public abstract class Start {

    public static void welcome() {
        //----GENERATE WELCOME MESSAGE----//
        System.out.println("DOPEMOB\npresents");
        System.out.println("\nBATTLE\nLEGENDS");
        System.out.println("\nPress ENTER to start");
        Scanner scanner = new Scanner(System.in); // No scanner.close() since it also closes System.in (necessary for program)

        while(true){ // while loop to only move ahead if user presses enter without entering any values
            String enter = scanner.nextLine();
            if(enter.equals("")) {
                break;
            }
        }
        System.out.println("GET READY FOR BATTLE!");
    }

}