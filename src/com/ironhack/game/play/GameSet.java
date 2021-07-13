package com.ironhack.game.play;

import java.util.ArrayList;

public class GameSet {
    private static int playMode;
    private static Player playerOne;
    private static Player playerTwo;

    // playMode getter and setter
    public static int getPlayMode() {
        return playMode;
    }

    public static void setPlayMode(int playMode) { // set with Menu.java by user selection
        GameSet.playMode = playMode;
    }

    // playerOne getter and setter
    public static Player getPlayerOne() {
        return playerOne;
    }

    public static void setPlayerOne(Player playerOne) {
        GameSet.playerOne = playerOne;
    }

    // playerTwo getter and setter
    public static Player getPlayerTwo() {
        return playerTwo;
    }

    public static void setPlayerTwo(Player playerTwo) {
        GameSet.playerTwo = playerTwo;
    }
}