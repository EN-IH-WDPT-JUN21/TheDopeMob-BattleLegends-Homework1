package com.ironhack.game.battle;


import com.ironhack.game.play.Player;

import java.util.ArrayList;

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

    //The most important part of this class, after the initialization this method starts the match and produces a MatchResult,
    //which stores info about the battles in a MatchResult class object
    public MatchResult getMatchResult() {
        int battleNo = 1;
        //Inside this loop the battles are created and started, then added to the list
        //here the fighting takes place
        while (playerHasAliveFighters(player1) && playerHasAliveFighters(player2)){
            Battle battle = new Battle(player1, player2);
            battle.startBattle();
            listOfBattles.add(battle);

            battleNo++;
        }
        //isTieMatch is needed for the messages in MatchResult
        boolean isTieMatch = !playerHasAliveFighters(player1) && !playerHasAliveFighters(player2);
        Player winner = playerHasAliveFighters(player1) ? player1 : player2;
        Player loser = playerHasAliveFighters(player1) ? player2 : player1;
        return new MatchResult(1,winner,loser,isTieMatch, listOfBattles);
    }

    //Earlier implementation was calculating if the characters are alive, now it only checks the size, after death the character is removed form the party
    private boolean playerHasAliveFighters(Player player){
        return player.getParty().size()>0;
    }
}
