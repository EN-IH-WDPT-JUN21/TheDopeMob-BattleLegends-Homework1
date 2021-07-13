package com.ironhack.game.play;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
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

    // Play again option
    public static void playAgain() throws FileNotFoundException {
        System.out.println("Play again?");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Yes                                      │");
        System.out.println("│[2] No                                       │");
        System.out.println("┖---------------------------------------------┚");
        Scanner scanner = new Scanner(System.in);

        int playAgain;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter [1] or [2].\n");
                scanner.next();
            }
            playAgain = scanner.nextInt();

            if (playAgain < 1 || playAgain > 2)
                System.out.println("Please enter [1] or [2].\n");

        } while (playAgain < 1 || playAgain > 2);

        switch (playAgain) {
            case 1:
                Menu.menuControl(1);
                break;
            case 2:
                System.out.println("Thank you for playing.\nNext legendary battles are waiting for you!");
                break;
            default:
                System.out.println("\nThings went south. Try again.");
        }
    }
    //Play music
    public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File musicFile = new File("src/com/ironhack/game/music/epic-sountrack.wav");
        try
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Can't play the soudtrack");
//            throw new UnsupportedAudioFileException("Can't play the soudtrack");
        }
    }
}