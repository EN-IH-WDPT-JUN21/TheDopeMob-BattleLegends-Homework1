package com.ironhack.game.battle;

import com.ironhack.game.character.Character;
import com.ironhack.game.play.GameSet;
import com.ironhack.game.graveyard.Grave;
import com.ironhack.game.graveyard.Graveyard;
import com.ironhack.game.play.Player;
import java.io.IOException;
import java.util.Scanner;

public class Battle {
    // STATIC FIELDS
    private static int battleTotalNumber = 0;
    // INSTANCE FIELDS
    private int roundTotalNumber;
    private int battleNumber;
    private final Player player1;
    private final Player player2;
    //player1Char and 2Char are initialized in the constructor, they are picked by getFighter() method
    Character player2Character;
    Character player1Character;
    //isTie is calculated inside startBattle() method
    private boolean isTie = false;
    //winner and loser are initialized inside startBattle() and later used toString()
    private Character winner;
    private Character loser;

    // CONSTRUCTOR
    public Battle(Player player1, Player player2) {
        setBattleNumber();
        this.player1 = player1;
        this.player2 = player2;
        //getFighter method picks the next alive character for the player with isHuman = false property
        //and for player.isHuman = true it prints a list of character and awaits user input which character to use (via Scanner class)
        this.player1Character = getFighter(player1);
        this.player2Character = getFighter(player2);
    }
    
    public void setBattleNumber() {
        //increments battle counter
        //battleTotalNumber is static
        this.battleNumber = battleTotalNumber + 1;
        battleTotalNumber++;
    }
    
    public int getBattleNo() {
        return battleNumber;
    }

    public int getRoundTotalNumber() {
        return roundTotalNumber;
    }

    public Character getPlayer1Character() {
        return player1Character;
    }

    public Character getPlayer2Character() {
        return player2Character;
    }

    public void startBattle() {
        //The most important method of this class, after the class is initialized with 2 players and the fighters from theirs party are picked
        //this method makes them fight with another. Whoever dies in the battle gets removed from theirs player party and is sent to the graveyard
        System.out.println("\n=====Start of battle " + battleNumber + "!=====");
        
        //The actual battle part, loop continues as long as one or both of the characters die during the battle 
        while(getPlayer1Character().isAlive() && getPlayer2Character().isAlive()){
            roundTotalNumber++;
            //The attack implementation is moved to the specialized character class (Wizard, Warrior)
            //We tried to keep to characters api as simple as it gets
            System.out.println("\nStarting round "+roundTotalNumber+"!");
            getPlayer2Character().defaultAttack(getPlayer1Character());
            getPlayer1Character().defaultAttack(getPlayer2Character());
        }
        //This part of code is accessed only after the battle is finished, so one or both characters are dead.
        //If both are dead then is a tie, if not the isTie is already initialized as false
        if (!player1Character.isAlive() && !player2Character.isAlive()){
            isTie = true;
        }
        //losingPlayer is needed for the graveyard functionality to create a new grave
        Player losingPlayer;
        //Setting the winning and losing characters, now we won't refer to them as player1Char, player2Char but winner and loser
        if (player1Character.isAlive()){
            winner = getPlayer1Character();
            losingPlayer = player2;
            loser = getPlayer2Character();
        }
        else{
            winner=getPlayer2Character();
            losingPlayer = player1;
            loser=getPlayer1Character();
        }

        //Cleaning up after the battle, creating graves, removing chars from parties
        //Graveyard is a list of Graves, so each character death is creating a new grave and adding it to the static graveyard.graves list.
        System.out.println("\nBattle "+battleNumber+" has ended!");
        if (isTie){
            //if it's a tie that means both characters are dead, then we remove both from theirs party and create 2 graves for them
            System.out.println("Both fighters are dead. It's a tie!");
            Grave player1Grave = new Grave(player1Character, player1.getName(), player2Character.getName(),battleNumber);
            Grave player2Grave = new Grave(player2Character, player2.getName(), player1Character.getName(),battleNumber);
            Graveyard.addGrave(player1Grave);
            Graveyard.addGrave(player2Grave);
            player1.getParty().remove(player1Character);
            player2.getParty().remove(player2Character);
        }
        else {
            //If it's not a tie then only the loser died and we create a grave for him and remove him from his party.
            //Here we need the losingPlayer variable, because without it we don't know who's the owner of the loser character.
            System.out.println("Winner: " + winner.getName());
            System.out.println("loser: " + loser.getName());
            Grave grave = new Grave(loser, losingPlayer.getName(), winner.getName(),battleNumber);
            Graveyard.addGrave(grave);
            losingPlayer.getParty().remove(loser);
        }
    }
    //getFighter acts differently for a player.isHuman=true and isHuman=false
    //1)isHuman=true - it prints the list of characters in the players party and uses Scanner.nextInt method to await for user input, input is validated
    //2)isHuman=false - picks next character from the list, if there's not character left returns null, but the match should end by the time a player has no characters.
    private Character getFighter(Player player){
        if (player.isHuman()){
            //different message for the first and next fight
            String message="";
            if (battleNumber==1){
                message = "\n"+player.getName()+ " pick a fighter for the 1 battle!";
            }
            else{
                message="\nBattle has ended, "+ player.getName() +" pick your next fighter...";
            }
            System.out.println(message);
            System.out.println("Input character ID to pick him");
            //Printing character list to pick from, picking by character ID
            for(Character ch : player.getParty()){
                System.out.println(ch);
            }
            int characterIdPicked;
            Character characterPicked = null;
            //Awaiting user input and validating it in a loop, only valid inputs break the loop, invalid throws an error which is caught and the loop continues
            boolean invalidInput = true;
            while (invalidInput){
                try {
                    //Getting input from scanner
                    Scanner scn = new Scanner(System.in);
                    characterIdPicked = scn.nextInt();
                    //Validating, probably an overkill, because getCharacter method throws an exception if it can't find a character with given ID
                    //but it's safe to have more validation then less
                    characterPicked = player.getCharacter(characterIdPicked);
                    characterPicked.getName();
                    if (characterPicked==null){
                        throw new Exception("Enter valid character ID");
                    }
                } catch (Exception e){
                    //in case invalid input, repeat loop
                    System.out.println("Input a valid character ID to pick him");
                    continue;
                }
                //this part of the code is only accessed if there was valid input, changes the loop condition to false and breaks the loop
                invalidInput=false;
            }
            //end of method for isHuman=true
            return characterPicked;
        }else {
            //behaviour for player.isHuman=false value, it picks the next available fighter, if there's no fighter returns null but the fight won't get to this stage
            Character nextFighter = null;
            for(Character fighter : player.getParty()){
                    nextFighter = fighter;
                    break;
            }
            return nextFighter;
        }
    }
    //Creating message for the battle summary after the match
    @Override
    public String toString() {
        String lastSentance ="";
        if (isTie){
            lastSentance = "Both warriors died, the match ended in a tie!";
        }
        else{
            lastSentance = winner.getName()+" has beaten "+loser.getName();
        }
        return "\nBattle "+battleNumber+" lasted for "+roundTotalNumber+" rounds!\n"+
                player1Character.getName()+" fought against "+player2Character.getName()+"!\n"+
                lastSentance+"\n";

    }
}
