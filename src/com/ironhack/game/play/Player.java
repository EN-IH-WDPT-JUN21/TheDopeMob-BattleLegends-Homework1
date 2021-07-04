package com.ironhack.game.play;

import java.util.ArrayList;
//Imported mockup characters for integration, the correct class is commented out
import com.ironhack.game.battle.mockup.Character;
//import com.ironhack.game.character.Character;

public class Player {
    // Instance fields
    private String name;
    private ArrayList<Character> party;
    // Constructor
    public Player(String name) {
        this.name = name;
        this.party = new ArrayList<>(); // Initializes to an empty party
    }
    // name getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Get party added by Wojtek Drygas, needed for match class
    public ArrayList<Character> getParty() {
        return party;
    }

    public void setParty(ArrayList<Character> party) {
        this.party = party;
    }


    // Method to add characters to player party. Used by the classes in party module
    public void addCharacter(Character character) {
        this.party.add(character);
    }

    // Method to retrieve specific character in list
    public Character getCharacter(int i) {
        return getParty().get(i);
    }

    // toString()
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", party=" + party +
                '}';
    }
}
