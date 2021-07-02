package com.ironhack.game.battle;

import com.ironhack.game.battle.interfaces.Fightable;

public class BattleResult {
    private final Fightable winner;
    private final Fightable looser;
    private final boolean isTie;
    private final int roundCount;
    private final int battleNo;

    public int getRoundCount() {
        return roundCount;
    }

    public int getBattleNo() {
        return battleNo;
    }

    public BattleResult(Fightable winner, Fightable looser, boolean isTie, int roundCount, int battleNo) {
        this.winner = winner;
        this.looser = looser;
        this.isTie = isTie;
        this.roundCount=roundCount;
        this.battleNo = battleNo;

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
        return "\nBattle "+battleNo+" result!" +
                "\nFight lasted for: "+roundCount+" rounds!"+
                "\nWinner=" + winner.getName() +
                "\nLooser=" + looser.getName() +
                "\nIsTie=" + isTie;
    }
}