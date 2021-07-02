package com.ironhack.game.battle;

import com.ironhack.game.battle.interfaces.Fightable;
//Imported mockup characters for integration, the correct class is commented out
import com.ironhack.game.battle.mockup.Character;
//import com.ironhack.game.character.Character;
import com.ironhack.game.play.Player;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final int id;
    private final Player redPlayer;
    private final Player bluePlayer;

    public Match(int id, Player redPlayer, Player bluePlayer) {
        this.id = id;
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
    }

    public int getId() {
        return id;
    }

    public Player getRedPlayer() {
        return redPlayer;
    }


    public Player getBluePlayer() {
        return bluePlayer;
    }

    public MatchResult getMatchResult() {
        List<BattleResult> battles = new ArrayList<>();
        while (playerHasAliveFighters(redPlayer) && playerHasAliveFighters(bluePlayer)){
            Fightable redFighter = getFighter(redPlayer);
            Fightable blueFighter = getFighter(bluePlayer);
            Battle battle = new Battle(redFighter, blueFighter);
            battles.add(battle.getResult());
        }
        boolean isTieMatch = !playerHasAliveFighters(redPlayer) && !playerHasAliveFighters(bluePlayer);
        Player winner = playerHasAliveFighters(redPlayer) ? redPlayer : bluePlayer;
        Player looser = playerHasAliveFighters(redPlayer) ? bluePlayer : redPlayer;
        return new MatchResult(1,winner,looser,isTieMatch, battles);
    }
    private Fightable getFighter(Player player){
        Fightable nextFighter=null;
        for(Character fighter : player.getParty()){
            if (fighter.isAlive()){
                nextFighter = (Fightable)fighter;
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
