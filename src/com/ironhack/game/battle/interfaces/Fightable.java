package com.ironhack.game.battle.interfaces;

public interface Fightable {
    void getHit(int power);
    void attack(Fightable opponent);
    boolean isAlive();
    String getStatus();

}
