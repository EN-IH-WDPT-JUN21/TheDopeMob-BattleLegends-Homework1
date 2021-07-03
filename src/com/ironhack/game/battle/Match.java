package com.ironhack.game.battle;

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
        int battleNo=1;
        while (playerHasAliveFighters(redPlayer) && playerHasAliveFighters(bluePlayer)){
            Character redFighter = getFighter(redPlayer);
            Character blueFighter = getFighter(bluePlayer);
            Battle battle = new Battle(redFighter, blueFighter, battleNo);
            battles.add(battle.getResult());
            battleNo++;
        }
        boolean isTieMatch = !playerHasAliveFighters(redPlayer) && !playerHasAliveFighters(bluePlayer);
        Player winner = playerHasAliveFighters(redPlayer) ? redPlayer : bluePlayer;
        Player looser = playerHasAliveFighters(redPlayer) ? bluePlayer : redPlayer;
        return new MatchResult(1,winner,looser,isTieMatch, battles);
    }
    private Character getFighter(Player player){
        Character nextFighter=null;
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
