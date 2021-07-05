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
    Character player2Character;
    Character player1Character;
    private boolean isTie = false;
    private Character winner;
    private Character looser;

    // CONSTRUCTOR
    public Battle(Player player1, Player player2) {
        setBattleNumber();
        this.player1 = player1;
        this.player2 = player2;
        this.player1Character = getFighter(player1);
        this.player2Character = getFighter(player2);
    }
    
    public void setBattleNumber() {
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

        System.out.println("\n=====Start of battle " + battleNumber + "!=====");

        while(getPlayer1Character().isAlive() && getPlayer2Character().isAlive()){
            roundTotalNumber++;
            System.out.println("\nStarting round "+roundTotalNumber+"!");
            getPlayer2Character().defaultAttack(getPlayer1Character());
            getPlayer1Character().defaultAttack(getPlayer2Character());
        }
        if (!player1Character.isAlive() && !player2Character.isAlive()){
            isTie = true;
        }
        String winningPlayerName;
        Player loosingPlayer;
        if (player1Character.isAlive()){
            winner = getPlayer1Character();
            winningPlayerName = player1.getName();
            loosingPlayer = player2;
            looser = getPlayer2Character();
        }
        else{
            winner=getPlayer2Character();
            loosingPlayer = player1;
            winningPlayerName = player2.getName();
            looser=getPlayer1Character();
        }


        System.out.println("\nBattle "+battleNumber+" has ended!");
        if (isTie){
            System.out.println("Both fighters are dead. It's a tie!");
            Grave player1Grave = new Grave(player1Character, player1.getName(), player2Character.getName(),battleNumber,isTie);
            Grave player2Grave = new Grave(player2Character, player2.getName(), player1Character.getName(),battleNumber,isTie);
            Graveyard.addGrave(player1Grave);
            Graveyard.addGrave(player2Grave);
            player1.getParty().remove(player1Character);
            player2.getParty().remove(player2Character);
        }
        else {
            System.out.println("Winner: " + winner.getName());
            System.out.println("Looser: " + looser.getName());
            Grave grave = new Grave(looser, winningPlayerName,winner.getName(),battleNumber,isTie);
            Graveyard.addGrave(grave);
            loosingPlayer.getParty().remove(looser);

        }
    }
    private Character getFighter(Player player){
        if (player.isHuman()){
            String message="";
            if (battleNumber==1){
                message = "\n"+player.getName()+ " pick a fighter for the 1 battle!";
            }
            else{
                message="\nBattle has ended, "+ player.getName() +" pick your next fighter...";
            }
            System.out.println(message);
            System.out.println("Input character ID to pick him");
            int i=0;
            for(Character ch : player.getParty()){
                System.out.println("ID:"+i+" "+ch);
                i++;
            }
            int characterIdPicked;
            Character characterPicked = null;
            boolean invalidInput = true;
            while (invalidInput){
                try {
                    Scanner scn = new Scanner(System.in);
                    characterIdPicked = scn.nextInt();
                    characterPicked = player.getCharacter(characterIdPicked);
                    characterPicked.getName();
                    if (characterPicked==null){
                        throw new Exception("Eneter valid character ID");
                    }
                } catch (Exception e){
                    System.out.println("Input a valid character ID to pick him");
                    continue;
                }
                invalidInput=false;
            }
            return characterPicked;
        }else {
            Character nextFighter = null;
            for(Character fighter : player.getParty()){
                if (fighter.isAlive()){
                    nextFighter = fighter;
                    break;
                }
            }
            return nextFighter;
        }
    }

    @Override
    public String toString() {
        String lastSentance ="";
        if (isTie){
            lastSentance = "Both warriors died, the match ended in a tie!";
        }
        else{
            lastSentance = winner.getName()+" has beaten "+looser.getName();
        }
        return "\nBattle "+battleNumber+" lasted for "+roundTotalNumber+" rounds!\n"+
                player1Character.getName()+" fought against "+player2Character.getName()+"!\n"+
                lastSentance+"\n";

    }
}
