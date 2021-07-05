package com.ironhack.game.graveyard;

import com.ironhack.game.character.Character;

public class Grave {
    private final Character character;
    private final String playerName;
    private final String opponentName;
    private final int battleNumber;

    public Grave(Character character, String playerName, String opponentName, int battleNumber) {
        this.character = character;
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.battleNumber = battleNumber;
    }

    public Character getCharacter() {
        return character;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public int getBattleNumber() {
        return battleNumber;
    }

    @Override
    public String toString() {
        return character.getName()+" from "+playerName+"'s party died in battle "+battleNumber+" fighting against "+opponentName;
    }
}
