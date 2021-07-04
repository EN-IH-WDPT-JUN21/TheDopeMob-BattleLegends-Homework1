package com.ironhack.game.battle;

import com.ironhack.game.character.Character;

public class Battle {
    private final Character blueFighter;
    private final Character redFighter;
    private int roundCount;
    private final int battleNo;

    public int getBattleNo() {
        return battleNo;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Battle(Character blueFighter, Character redFighter, int battleNo) {
        this.blueFighter = blueFighter;
        this.redFighter = redFighter;
        roundCount=0;
        this.battleNo = battleNo;
    }

    public Character getBlueFighter() {
        return blueFighter;
    }

    public Character getRedFighter() {
        return redFighter;
    }

    public BattleResult getResult() {
        System.out.println("\n=====Start of battle "+battleNo+"!=====");
        Character winner;
        Character looser;
        boolean isTie=false;
        while(blueFighter.isAlive() && redFighter.isAlive()){
            roundCount++;
            System.out.println("\nStarting round "+roundCount+"!");
            redFighter.attack(blueFighter);
            blueFighter.attack(redFighter);
        }
        if (!blueFighter.isAlive() && !redFighter.isAlive()){
            isTie=true;
        }
        if (blueFighter.isAlive()){
            winner = blueFighter;
            looser = redFighter;
        }
        else{
            winner=redFighter;
            looser=blueFighter;
        }
        System.out.println("Battle "+battleNo+" has ended!");
        System.out.println("Winner: "+winner.getName());
        System.out.println("Looser: "+looser.getName());
        return new BattleResult(winner,looser,isTie,roundCount,battleNo);
    }

}
