package com.ironhack.game.battle.mockup;

import com.ironhack.game.battle.Battle;
import com.ironhack.game.battle.Result;

public class BattleMockup {
    public static void main(String[] args) {
        Wizard wizard = new Wizard("1","Wiz",15,20,3);
        Warrior warrior = new Warrior("2","War",25,30,2);
        Battle battle = new Battle(wizard,warrior);
        Result result = battle.getResult();
        System.out.println(result);
    }
}
