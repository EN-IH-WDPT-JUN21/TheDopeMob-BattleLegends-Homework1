package com.ironhack.game.battle;

import com.ironhack.game.battle.interfaces.Fightable;

public class BattleResult {
    private final Fightable winner;
    private final Fightable looser;
    private final boolean isTie;
    private final int roundCount;

    public BattleResult(Fightable winner, Fightable looser, boolean isTie, int roundCount) {
        this.winner = winner;
        this.looser = looser;
        this.isTie = isTie;
        this.roundCount=roundCount;

    }

    public Fightable getWinner() {
        return winner;
    }

    public Fightable getLooser() {
        return looser;
    }

    public boolean isTie() {
        return isTie;
    }


    @Override
    public String toString() {
        return "\nBattle Result!" +
                "\nFight lasted for: "+roundCount+" rounds!"+
                "\nWinner=" + winner.getStatus() +
                "\nLooser=" + looser.getStatus() +
                "\nIsTie=" + isTie;
    }
}