package com.ironhack.game.play;

import com.ironhack.game.battle.Battle;
import com.ironhack.game.battle.Match;
import com.ironhack.game.battle.MatchResult;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Start.welcome(); // Initial message and signal for game set-up;
        Menu.menuControl(1); // Start game set-up step by step


        Match match = new Match(GameSet.getPlayerOne(), GameSet.getPlayerTwo());
        System.out.println(match.getMatchResult());


        // Repeat until one of the players (or both) have no characters left
        System.out.println("The winner is ...");
        System.out.println("Play again?");
    }
}