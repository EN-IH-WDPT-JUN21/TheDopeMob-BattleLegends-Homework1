package com.ironhack.game.battle;

import com.ironhack.game.character.Character;
import com.ironhack.game.play.Player;

public class Battle {
    // STATIC FIELDS
    private static int battleTotalNumber = 0;
    // INSTANCE FIELDS
    private int roundTotalNumber;
    private int battleNumber;
    private Character player1Character;
    private Character player2Character;
    // CONSTRUCTOR
    public Battle(Character player1Character, Character player2Character) {
        setBattleNumber();
        this.player1Character = player1Character;
        this.player2Character = player2Character;
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
        System.out.println("\n=====Start of battle "+battleNumber+"!=====");
        Character winner;
        Character looser;
        boolean isTie = false;
        while(getPlayer1Character().isAlive() && getPlayer2Character().isAlive()){
            roundTotalNumber++;
            System.out.println("\nStarting round "+roundTotalNumber+"!");
            getPlayer2Character().defaultAttack(getPlayer1Character());
            getPlayer1Character().defaultAttack(getPlayer2Character());

        }
        if (!player1Character.isAlive() && !player2Character.isAlive()){
            isTie = true;
        }
        if (player1Character.isAlive()){
            winner = getPlayer1Character();
            looser = getPlayer2Character();
        }
        else{
            winner=getPlayer2Character();
            looser=getPlayer1Character();
        }

        System.out.println("Battle "+battleNumber+" has ended!");
        System.out.println("Winner: "+winner.getName());
        System.out.println("Looser: "+looser.getName());

    }

}
