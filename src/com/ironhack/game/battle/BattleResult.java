package com.ironhack.game.battle;

import com.ironhack.game.battle.mockup.Character;

public class BattleResult {
    private final Character winner;
    private final Character looser;
    private final boolean isTie;
    private final int roundCount;
    private final int battleNo;

    public int getRoundCount() {
        return roundCount;
    }

    public int getBattleNo() {
        return battleNo;
    }

    public BattleResult(Character winner, Character looser, boolean isTie, int roundCount, int battleNo) {
        this.winner = winner;
        this.looser = looser;
        this.isTie = isTie;
        this.roundCount=roundCount;
        this.battleNo = battleNo;

    }

    public Character getWinner() {
        return winner;
    }

    public Character getLooser() {
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