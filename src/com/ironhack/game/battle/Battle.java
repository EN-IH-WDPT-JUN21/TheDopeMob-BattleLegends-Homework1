package com.ironhack.game.battle;

import com.ironhack.game.battle.interfaces.Fightable;

public class Battle {
    private final Fightable blueFighter;
    private final Fightable redFighter;
    private int roundCount;

    public Battle(Fightable blueFighter, Fightable redFighter) {
        this.blueFighter = blueFighter;
        this.redFighter = redFighter;
        roundCount=0;
    }

    public Fightable getBlueFighter() {
        return blueFighter;
    }

    public Fightable getRedFighter() {
        return redFighter;
    }

    public BattleResult getResult() {
        Fightable winner;
        Fightable looser;
        boolean isTie=false;
        while(blueFighter.isAlive() && redFighter.isAlive()){
            roundCount++;
            System.out.println("Starting round "+roundCount+"!");
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
        return new BattleResult(winner,looser,isTie,roundCount);
    }

}
