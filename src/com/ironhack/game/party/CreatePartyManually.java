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
        System.out.println("Please type down how many fighters each party should have: \n");

        Scanner scanner = new Scanner(System.in);

//        Must add correct input value validation
        partySizeLimit = scanner.nextInt();
        System.out.println("\nParties' size is set to " + partySizeLimit + "");
        return partySizeLimit;
    }

    //Set character's >>name<<
    public String setName() {
        System.out.println("\n(Step 1/5)\nPlease type the name of your fighter: \n");

        Scanner scanner = new Scanner(System.in);

//        Must add correct input value validation
        nameTemp = scanner.nextLine();
        System.out.println("\nYour fighter's name is " + nameTemp + "");
        return nameTemp;
    }

    //Pick character's >>class<<
    public int setCharacterClass() {
        System.out.println("\n(Step 2/5)\nPlease select " + nameTemp + "'s" + " class:");
        System.out.println("┎---------------------------------------------┒");
        System.out.println("│[1] Warrior                                  │");
        System.out.println("│[2] Wizard                                   │");
        System.out.println("┖---------------------------------------------┚");

        characterClassTemp = 0;

        //Verifying if selected option is available
        while (true) {
            Scanner scanner = new Scanner(System.in);
            characterClassTemp = scanner.nextInt();

//        Must add correct input value validation
            if (characterClassTemp >= 1 && characterClassTemp <= 2) {
                break;
            } else {
                System.out.println("\nPlease enter [1] or [2].");
            }
        }

        switch (characterClassTemp) {
            case 1:
                System.out.println("\n" + nameTemp + " is a Warrior now.");
                break;
            case 2:
                System.out.println("\n" + nameTemp + " is a Wizard now.");
                break;
            default:
                System.out.println("\nThings went south. Try again.");
                //Access point to Create your party phase
        }
        return characterClassTemp;
    }

    //Set character's >>HP<<
    public int setHp() {
        System.out.println("\n(Step 3/5)\nPlease set " + nameTemp + "'s" + " HP level (200 is max):\n");

        hpTemp = 0;

        //Verifying if input is correct
        while (true) {
            Scanner scanner = new Scanner(System.in);
            hpTemp = scanner.nextInt();

//        Must add correct input value validation
            if (hpTemp >= 1 && hpTemp <= 200) {
                System.out.println("\n" + nameTemp + "'s" + " HP is: " + hpTemp + "");
                break;
            } else {
                System.out.println("\n" + nameTemp + "'s HP should be set between 1 and 200. Try again!");
            }
        }
        return hpTemp;
    }

    //Warrior attributes customization
    //Set character's >>stamina<<
    public int setStamina() {

        if (characterClassTemp == 1) {
            System.out.println("\n(Step 4/5)\nPlease set " + nameTemp + "'s" + " stamina level (50 is max):\n");

            staminaTemp = 0;

            //Verifying if input is correct
            while (true) {
                Scanner scanner = new Scanner(System.in);
                staminaTemp = scanner.nextInt();

//        Must add correct input value validation
                if (staminaTemp >= 1 && staminaTemp <= 50) {
                    System.out.println("\n" + nameTemp + "'s" + " stamina is: " + staminaTemp + "");
                    break;
                } else {
                    System.out.println("\n" + nameTemp + "'s stamina should be set between 1 and 50. Try again!");
                }
            }
        }
        return staminaTemp;
    }

    //Set character's >>strength<<
    public int setStrength() {
        if (characterClassTemp == 1) {
            System.out.println("\n(Step 5/5)\nPlease set " + nameTemp + "'s" + " strength level (10 is max):\n");

            strengthTemp = 0;

            //Verifying if input is correct
            while (true) {
                Scanner scanner = new Scanner(System.in);
                strengthTemp = scanner.nextInt();

//        Must add correct input value validation
                if (strengthTemp >= 1 && strengthTemp <= 10) {
                    System.out.println("\n" + nameTemp + "'s" + " strength is: " + strengthTemp + "");
                    break;
                } else {
                    System.out.println("\n" + nameTemp + "'s strength should be set between 1 and 10. Try again!\n");
                }
            }
        }
        return strengthTemp;
    }

    //Wizard attributes customization
    //Set character's >>mana<<
    public int setMana() {
        if (characterClassTemp == 2) {
            System.out.println("\n(Step 4/5)\nPlease set " + nameTemp + "'s" + " mana level (50 is max):\n");

            manaTemp = 0;

            //Verifying if input is correct
            while (true) {
                Scanner scanner = new Scanner(System.in);
                manaTemp = scanner.nextInt();

//        Must add correct input value validation
                if (manaTemp >= 1 && manaTemp <= 50) {
                    System.out.println("\n" + nameTemp + "'s" + " mana is: " + manaTemp + "");
                    break;
                } else {
                    System.out.println("\n" + nameTemp + "'s mana should be set between 1 and 50. Try again!");
                }
            }
        }
        return manaTemp;
    }

    //Set character's >>intelligence<<
    public int setIntelligence() {
        if (characterClassTemp == 2) {
            System.out.println("\n(Step 5/5)\nPlease set " + nameTemp + "'s" + " intelligence level (50 is max):\n");

            intelligenceTemp = 0;

            //Verifying if input is correct
            while (true) {
                Scanner scanner = new Scanner(System.in);
                intelligenceTemp = scanner.nextInt();

//        Must add correct input value validation
                if (intelligenceTemp >= 1 && intelligenceTemp <= 50) {
                    System.out.println("\n" + nameTemp + "'s" + " intelligence is: " + intelligenceTemp + "");
                    break;
                } else {
                    System.out.println("\n" + nameTemp + "'s intelligence should be set between 1 and 50. Try again!");
                }
            }
        }
        return intelligenceTemp;
    }
}