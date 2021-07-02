package com.ironhack.game.battle.mockup;

import com.ironhack.game.battle.interfaces.Fightable;

public class Wizard extends Character {
    //CONSTS
    private final int MANA_USAGE=1;

    // Instance fields
    private int mana;
    private int Intelligence;

    // Constructor
    public Wizard(String id, String name, int hp, int mana, int intelligence) {
        super(id, name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    // Wizard uses getters and setters for id, name, hp and isAlive from Character
    // mana getters and setters
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    // intelligence getters and setters
    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    @Override
    public void getHit(int power) {
        setHp(getHp()-power);
        System.out.println(getName()+" got attacked for "+power+" and has "+getHp()+" hp left");
    }

    @Override
    public void attack(Fightable opponent) {
        if (mana<MANA_USAGE)
            System.out.println(getName()+" has no stamina!");
        else {
            opponent.getHit(getIntelligence());
            System.out.println(getName()+" attacked for "+getIntelligence());
        }
    }


    @Override
    public String getStatus() {
        return this.toString();
    }
}
