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
    String[] nameArray = {"Lydan", "Syrin", "Ptorik", "Joz", "Varog", "Gethrod", "Hezra", "Feron", "Ophni", "Rourke",
                          "Sir Gustavo the Great", "Colborn", "Fintis", "Gatlin", "Jinto", "Hagalbar", "Barton",
                          "Krinn", "Lenox", "Revvyn", "Hodus", "Dimian", "Sir Dave the Mighty", "Paskel", "Kontas",
                          "Weston", "Azamarr", "Jather", "Tekren", "Jareth", "Adon", "Zaden", "Eune", "Graff", "Tez",
                          "Jessop", "Gunnar", "Pike", "Domnhar", "Baske", "Jerrick", "Mavrek", "Riordan", "Wulfe",
                          "Straus", "Tyvrik", "Henndar", "Favroe", "Whit", "Jaris", "Renham", "Kagran", "Hemm", "Rivik",
                          "Sir Wojciech the Wise", "Lassrin", "Vadim", "Arlo", "Quintis", "Vale", "Caelan", "Yorjan",
                          "Khron", "Ishmael", "Jakrin", "Fangar", "Roux", "Baxar", "Hawke", "Gatlen", "Barak", "Nazim",
                          "Kadric", "Paquin", "Kent", "Moki", "Rankar", "Sir Jegor the Worthy", "Lothe", "Ryven",
                          "Clawsen", "Pakker", "Embre", "Cassian", "Verssek", "Dagfinn", "Ebraheim", "Nesso",
                          "Eldermar"};

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
        System.out.println("\nRandom party was created successfully\n");
    }

    //Set >>partySizeLimit<<
    public int setPartySizeLimit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type down how many fighters this party should have.");
        do {
            System.out.println("Party must have at least 1 fighter.");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter the number of fighters.");
                scanner.next();
            }
            partySizeLimit = scanner.nextInt();
        } while (partySizeLimit < 1);
        System.out.println("\nParty size is set to " + partySizeLimit + ".");
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