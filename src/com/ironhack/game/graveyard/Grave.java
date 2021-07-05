package com.ironhack.game.graveyard;

import com.ironhack.game.character.Character;

public class Grave {
    private final Character character;
    private final String playerName;
    private final String opponentName;
    private final int battleNumber;
    private final boolean matchTied;

    public Grave(Character character, String playerName, String opponentName, int battleNumber, boolean matchTied) {
        this.character = character;
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.battleNumber = battleNumber;
        this.matchTied = matchTied;
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

    public boolean isMatchTied() {
        return matchTied;
    }

    @Override
    public String toString() {
        String lastSentance ="";
        if (matchTied){
            lastSentance = "He took his opponet to grave with him";
        }
        else{
            lastSentance ="His opponent was overwhelming";
        }
        return character.getName()+" from "+playerName+"'s party died in battle "+battleNumber+" fighting against "+opponentName+
                "\n"+lastSentance;
    }
}
