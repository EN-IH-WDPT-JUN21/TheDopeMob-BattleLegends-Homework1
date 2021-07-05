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
        listOfBattles = new ArrayList<>();
    }

    public Player getplayer1() {
        return player1;
    }

    public Player getplayer2() {
        return player2;
    }

    public MatchResult getMatchResult() {
        int battleNo = 1;
        while (playerHasAliveFighters(player1) && playerHasAliveFighters(player2)){
            Battle battle = new Battle(player1, player2);
            battle.startBattle();
            listOfBattles.add(battle);

            battleNo++;
        }
        boolean isTieMatch = !playerHasAliveFighters(player1) && !playerHasAliveFighters(player2);
        Player winner = playerHasAliveFighters(player1) ? player1 : player2;
        Player loser = playerHasAliveFighters(player1) ? player2 : player1;
        return new MatchResult(1,winner,loser,isTieMatch, listOfBattles);
    }

    private boolean playerHasAliveFighters(Player player){
        return player.getParty().size()>0;
    }
}
