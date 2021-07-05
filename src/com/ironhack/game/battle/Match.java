package com.ironhack.game.battle;


import com.ironhack.game.character.Character;
import com.ironhack.game.play.Player;
import java.util.ArrayList;
import java.util.List;

public class Match {
    // Instance fields
    private final Player player1;
    private final Player player2;
    private ArrayList<Battle> listOfBattles;


    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getplayer1() {
        return player1;
    }

    public Player getplayer2() {
        return player2;
    }

    public MatchResult getMatchResult() {
        List<BattleResult> battles = new ArrayList<>();

        int battleNo = 1;
        while (playerHasAliveFighters(player1) && playerHasAliveFighters(player2)){
            Character redFighter = getFighter(player1);
            Character blueFighter = getFighter(player2);
            Battle battle = new Battle(redFighter, blueFighter);
            battle.startBattle();

            battleNo++;
        }
        boolean isTieMatch = !playerHasAliveFighters(player1) && !playerHasAliveFighters(player2);
        Player winner = playerHasAliveFighters(player1) ? player1 : player2;
        Player looser = playerHasAliveFighters(player1) ? player2 : player1;
        return new MatchResult(1,winner,looser,isTieMatch, battles);
    }

    private Character getFighter(Player player){
        Character nextFighter = null;
        for(Character fighter : player.getParty()){
            if (fighter.isAlive()){
                nextFighter = fighter;
                break;
            }
        }
        return nextFighter;
    }
    private boolean playerHasAliveFighters(Player player){
        boolean hasAliveFighters = false;
        for(Character fighter : player.getParty()){
            if (fighter.isAlive()){
                hasAliveFighters = true;
                break;
            }
        }
        return hasAliveFighters;
    }
}
