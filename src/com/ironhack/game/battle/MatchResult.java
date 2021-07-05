package com.ironhack.game.battle;

import com.ironhack.game.play.Player;

import java.util.List;

public class MatchResult {

    private final int matchId;
    private final Player winner;
    private final Player looser;
    private final boolean wasTie;
    private final List<Battle> battles;

    public MatchResult(int matchId, Player winner, Player looser, boolean wasTie, List<Battle> battles) {
        this.matchId = matchId;
        this.winner = winner;
        this.looser = looser;
        this.wasTie = wasTie;
        this.battles=battles;
    }

    public boolean isWasTie() {
        return wasTie;
    }

    public int getMatchId() {
        return matchId;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLooser() {
        return looser;
    }
    public List<Battle> getBattles() { return battles; }

    @Override
    public String toString() {
        String resultMessage = "";
        if (wasTie) {
            resultMessage = "The match against "+winner.getName()+" and "+looser.getName()+" ended in a tie";
        }
        else{
            resultMessage = winner.getName()+" won the match against "+looser.getName();
        }
        return "\n\n===========MatchResult=========\n" +
                resultMessage+"\nQuick look at the battles below:\n"+
                battles;
    }
}
