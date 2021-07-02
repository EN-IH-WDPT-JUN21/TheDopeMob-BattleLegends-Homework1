package com.ironhack.game.battle.mockup;

import com.ironhack.game.battle.BattleResult;
import com.ironhack.game.battle.MatchResult;

import java.util.List;

public class MockupGraveyard {
    private MatchResult matchResult;

    public MockupGraveyard(MatchResult matchResult) {
        this.matchResult = matchResult;
    }
    public void printGraveyard() {
        List<Character> winnerCharacters = matchResult.getWinner().getParty();
        List<Character> looserCharacters = matchResult.getLooser().getParty();

        System.out.println("\nDead characters from winning player: "+matchResult.getWinner().getName());
        for (Character character : winnerCharacters){
            if (!character.isAlive()){
                System.out.println(character.getName());
            }
        }
        System.out.println("\nDead characters from loosing player: "+matchResult.getLooser().getName());
        for (Character character : looserCharacters){
            if (!character.isAlive()){
                System.out.println(character.getName());
            }
        }
    }
    public void printBattleDeaths(){
        System.out.println("\nBattles deaths details");
        for(BattleResult battle : matchResult.getBattles()){
            System.out.println("\nIn battle:"+battle.getBattleNo());
            System.out.println(battle.getLooser().getName()+" died by the hand of: "+battle.getWinner().getName());
            System.out.println("The battle lasted: "+battle.getRoundCount()+" round.");

        }
    }

}
