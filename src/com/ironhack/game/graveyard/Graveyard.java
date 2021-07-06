package com.ironhack.game.graveyard;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {
    //Graveyard prints the content of each Grave, simple functionality
    private static List<Grave> graves = new ArrayList<>();
    public static List<Grave> getGraves() {
        return graves;
    }
    public static void addGrave(Grave grave) {
        graves.add(grave);
    }
    public static void printGravesInfo(){
        System.out.println("\n\n======GRAVEYARD======\n");
        for (Grave grave : graves){
            System.out.println(grave);
        }
    }
}
