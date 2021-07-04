package com.ironhack.game.party;

import com.ironhack.game.character.Warrior;
import com.ironhack.game.character.Wizard;
import com.ironhack.game.play.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CreatePartyRandomly {
    private int partySizeLimit = 10;

    private String nameTemp;
    private int characterClassTemp; //(1 = Warrior, 2 = Wizard)
    private int hpTemp;             //(range 100-200 for warriors and 50-100 for wizards)
    private int staminaTemp;        //(range 10-50)
    private int strengthTemp;       //(range 1-10)
    private int manaTemp;           //(range 10-50)
    private int intelligenceTemp;   //(range 1-50)

    //Array of random fighter names
    String[] nameArray = {"Lydan", "Syrin", "Ptorik", "Joz", "Varog", "Gethrod", "Hezra", "Feron",
            "Ophni", "Colborn", "Fintis", "Gatlin", "Jinto", "Hagalbar", "Krinn",
            "Lenox", "Revvyn", "Hodus", "Dimian", "Paskel", "Kontas", "Weston",
            "Azamarr", "Jather", "Tekren", "Jareth", "Adon"};

    //Creating parties randomly
    public void createPartyRandomly(Player player) {

        //Player sets the size of parties
        setPartySizeLimit();

        //Creating fighters and adding them to party1 ArrayLists
        for (int partySizeCounter = 0; partySizeCounter < partySizeLimit; partySizeCounter++) {

            //Setting random name
            setName();

            //Checking is such name exists among already created fighters and adding "Jr" at the end
            for (int i = 0; i < player.getParty().size(); i++) {
                if (nameTemp.equals(player.getParty().get(i).getName())) {
                    nameTemp = nameTemp + " Jr";
                }
            }

            //Setting random parameters
            setCharacterClass();
            setHp();
            setStamina();
            setStrength();
            setMana();
            setIntelligence();

            //Fighter objects are created and added to party ArrayLists
            if (characterClassTemp == 1) {
                player.addCharacter(new Warrior(nameTemp, hpTemp, staminaTemp, strengthTemp));
            } else if (characterClassTemp == 2) {
                player.addCharacter(new Wizard(nameTemp, hpTemp, manaTemp, intelligenceTemp));
            }
//                Access to hero object method toString to summarize a new character;
        }
        System.out.println("\nComputer's party was created successfully");
    }

    //Set >>partySizeLimit<<
    public int setPartySizeLimit() {
        System.out.println("\nPlease type down how many fighters each party should have: \n");

        Scanner scanner = new Scanner(System.in);

//        Must add correct input value validation
        partySizeLimit = scanner.nextInt();
        System.out.println("\nParty's size is set to " + partySizeLimit + " fighters each.");
        return partySizeLimit;
    }

    //Random String picker
    public static String getRandom(String[] random) {
        int rnd = new Random().nextInt(random.length);
        return random[rnd];
    }

    //Random selection of character's >>name<<
    public String setName() {
        nameTemp = getRandom(nameArray);
        return nameTemp;
    }

    //Random selection of character's >>class<<
    public int setCharacterClass() {
        characterClassTemp = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        return characterClassTemp;
    }

    //Random selection of character's >>HP<<
    public int setHp() {
        if (characterClassTemp == 1) {
            hpTemp = ThreadLocalRandom.current().nextInt(100, 200 + 1);
        }
        if (characterClassTemp == 2) {
            hpTemp = ThreadLocalRandom.current().nextInt(50, 100 + 1);
        }
        return hpTemp;
    }

    //Warrior attributes
    //Random selection of character's >>stamina<<
    public int setStamina() {

        if (characterClassTemp == 1) {
            staminaTemp = ThreadLocalRandom.current().nextInt(10, 50 + 1);
        }
        return staminaTemp;
    }

    //Random selection of character's >>strength<<
    public int setStrength() {
        if (characterClassTemp == 1) {
            strengthTemp = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        }
        return strengthTemp;
    }

    //Wizard attributes
    //Random selection of character's >>mana<<
    public int setMana() {
        if (characterClassTemp == 2) {
            manaTemp = ThreadLocalRandom.current().nextInt(10, 50 + 1);
        }
        return manaTemp;
    }

    //Random selection of character's >>intelligence<<
    public int setIntelligence() {
        if (characterClassTemp == 2) {
            intelligenceTemp = ThreadLocalRandom.current().nextInt(1, 50 + 1);
        }
        return intelligenceTemp;
    }
}