package com.ironhack.game.party;

import com.ironhack.game.character.Warrior;
import com.ironhack.game.character.Wizard;
import com.ironhack.game.play.Player;

import java.util.Scanner;

public class CreatePartyManually {
    private int partySizeLimit;
    private String nameTemp;
    private int characterClassTemp; //(1 = Warrior, 2 = Wizard)
    private int hpTemp;             //(range 1-200)
    private int staminaTemp;        //(range 1-50)
    private int strengthTemp;       //(range 1-10)
    private int manaTemp;           //(range 1-50)
    private int intelligenceTemp;   //(range 1-50)
    private int playerCounter = 0;

    //Creating party manually
    public void createPartyManually(Player player) {

        //Player sets the size of parties
        setPartySizeLimit();

        //Creating fighters and adding them to party of Player 1 ArrayLists
        for (int partySizeCounter = 1; partySizeCounter < partySizeLimit + 1; partySizeCounter++) {

            System.out.println("\nLet's create a Fighter #" + partySizeCounter + ":");

            setName();
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
    }

    //Set >>partySizeLimit<<
    public int setPartySizeLimit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type down how many fighters your party should have.");
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

    //Set character's >>name<<
    public String setName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n(Step 1/5)\nPlease type the name of your fighter.\nYour fighter cannot be nameless.");
        nameTemp = scanner.next();
        System.out.println("\nYour fighter's name is " + nameTemp + ".");
        return nameTemp;
    }

    //Pick character's >>class<<
    public int setCharacterClass() {
        System.out.println("\n(Step 2/5)\nPlease select " + nameTemp + "'s" + " class:");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Warrior                                  │");
        System.out.println("│[2] Wizard                                   │");
        System.out.println("┖---------------------------------------------┚");

        Scanner scanner = new Scanner(System.in);
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter [1] or [2].\n");
                scanner.next();
            }
            characterClassTemp = scanner.nextInt();

            if (characterClassTemp < 1 || characterClassTemp > 2)
                System.out.println("Please enter [1] or [2].\n");

        } while (characterClassTemp < 1 || characterClassTemp > 2);

        switch (characterClassTemp) {
            case 1:
                System.out.println("\n" + nameTemp + " is a Warrior now.");
                break;
            case 2:
                System.out.println("\n" + nameTemp + " is a Wizard now.");
                break;
            default:
                System.out.println("\nThings went south. Try again.");
        }
        return characterClassTemp;
    }

    //Set character's >>HP<<
    public int setHp() {
        System.out.println("\n(Step 3/5)\nPlease set " + nameTemp + "'s" + " HP level (200 is max):\n");
        Scanner scanner = new Scanner(System.in);
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("\n" + nameTemp + "'s HP should be set between 1 and 200. Try again!\n");
                scanner.next();
            }
            hpTemp = scanner.nextInt();

            if (hpTemp < 1 || hpTemp > 200)
                System.out.println("\n" + nameTemp + "'s HP should be set between 1 and 200. Try again!\n");

        } while (hpTemp < 1 || hpTemp > 200);

        System.out.println("\n" + nameTemp + "'s" + " HP is: " + hpTemp + ".\n");
        return hpTemp;
    }

    //Warrior attributes customization
    //Set character's >>stamina<<
    public int setStamina() {
        if (characterClassTemp == 1) {
            System.out.println("\n(Step 4/5)\nPlease set " + nameTemp + "'s" + " stamina level (50 is max):\n");
            Scanner scanner = new Scanner(System.in);

            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("\n" + nameTemp + "'s stamina should be set between 1 and 50. Try again!\n");
                    scanner.next();
                }
                staminaTemp = scanner.nextInt();

                if (staminaTemp < 1 || staminaTemp > 50)
                    System.out.println("\n" + nameTemp + "'s stamina should be set between 1 and 50. Try again!\n");

            } while (staminaTemp < 1 || staminaTemp > 50);

            System.out.println("\n" + nameTemp + "'s" + " stamina is: " + staminaTemp + ".\n");

        }
        return staminaTemp;
    }

    //Set character's >>strength<<
    public int setStrength() {
        if (characterClassTemp == 1) {
            System.out.println("\n(Step 5/5)\nPlease set " + nameTemp + "'s" + " strength level (10 is max):\n");
            Scanner scanner = new Scanner(System.in);

            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("\n" + nameTemp + "'s strength should be set between 1 and 10. Try again!\n");
                    scanner.next();
                }
                strengthTemp = scanner.nextInt();

                if (strengthTemp < 1 || strengthTemp > 10)
                    System.out.println("\n" + nameTemp + "'s strength should be set between 1 and 10. Try again!\n");

            } while (strengthTemp < 1 || strengthTemp > 10);

            System.out.println("\n" + nameTemp + "'s" + " strength is: " + strengthTemp + ".\n");
        }
        return strengthTemp;
    }

    //Wizard attributes customization
    //Set character's >>mana<<
    public int setMana() {
        if (characterClassTemp == 2) {
            System.out.println("\n(Step 4/5)\nPlease set " + nameTemp + "'s" + " mana level (50 is max):\n");
            Scanner scanner = new Scanner(System.in);

            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("\n" + nameTemp + "'s mana should be set between 1 and 50. Try again!\n");
                    scanner.next();
                }
                manaTemp = scanner.nextInt();

                if (manaTemp < 1 || manaTemp > 50)
                    System.out.println("\n" + nameTemp + "'s mana should be set between 1 and 50. Try again!\n");

            } while (manaTemp < 1 || manaTemp > 50);

            System.out.println("\n" + nameTemp + "'s" + " mana is: " + manaTemp + ".\n");
        }
        return manaTemp;
    }

    //Set character's >>intelligence<<
    public int setIntelligence() {
        if (characterClassTemp == 2) {
            System.out.println("\n(Step 5/5)\nPlease set " + nameTemp + "'s" + " intelligence level (50 is max):\n");
            Scanner scanner = new Scanner(System.in);

            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("\n" + nameTemp + "'s intelligence should be set between 1 and 50. Try again!\n");
                    scanner.next();
                }
                intelligenceTemp = scanner.nextInt();

                if (intelligenceTemp < 1 || intelligenceTemp > 50)
                    System.out.println("\n" + nameTemp + "'s intelligence should be set between 1 and 50. Try again!\n");

            } while (intelligenceTemp < 1 || intelligenceTemp > 50);

            System.out.println("\n" + nameTemp + "'s" + " intelligence is: " + intelligenceTemp + ".\n");
        }
        return intelligenceTemp;
    }
}
