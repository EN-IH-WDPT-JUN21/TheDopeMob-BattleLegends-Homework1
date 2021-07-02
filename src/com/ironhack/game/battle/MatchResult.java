package com.ironhack.game.battle;

import com.ironhack.game.play.Player;

import java.util.List;

public class MatchResult {
    private final int matchId;
    private final Player winner;
    private final Player looser;
    private final boolean wasTie;
    private final List<BattleResult> battles;

    public MatchResult(int matchId, Player winner, Player looser, boolean wasTie, List<BattleResult> battles) {
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
    public List<BattleResult> getBattles() { return battles; }

    @Override
    public String toString() {
        return "\n\n===========MatchResult=========\n{" +
                "matchId=" + matchId +
                ", winner=" + winner.getName() +
                ", looser=" + looser.getName() +
                ", wasTie=" + wasTie +
                ", battles=" + battles +
                '}';
    }
}
