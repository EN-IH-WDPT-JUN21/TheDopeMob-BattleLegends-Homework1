package com.ironhack.game.battle.mockup;

import com.ironhack.game.battle.Battle;
import com.ironhack.game.battle.BattleResult;
import com.ironhack.game.battle.Match;
import com.ironhack.game.battle.MatchResult;
import com.ironhack.game.play.Player;

public class BattleMockup {
    public static void main(String[] args) {
        Wizard rWiz = new Wizard("1","Red-Wiz",15,20,5);
        Warrior rWar = new Warrior("2","Red-War",25,30,6);
        Wizard bWiz = new Wizard("1","Blue-Wiz",100,20,4);
        Warrior bWar = new Warrior("2","Blue-War",200,30,5);
        Player red = new Player("Red");
        red.addCharacter(rWar);
        red.addCharacter(rWiz);
        Player blue = new Player("Blue");
        blue.addCharacter(bWar);
        blue.addCharacter(bWiz);
        Match match = new Match(1,red,blue);
        MatchResult matchResult = match.getMatchResult();
        System.out.println(matchResult);

        //Graveyard
        MockupGraveyard mockup = new MockupGraveyard(matchResult);
        mockup.printGraveyard();
        mockup.printBattleDeaths();
    }

}
