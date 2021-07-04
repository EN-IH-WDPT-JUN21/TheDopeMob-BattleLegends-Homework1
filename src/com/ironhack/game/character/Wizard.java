package com.ironhack.game.character;

public class Wizard extends Character {

    // Instance fields
    private int mana;
    private int Intelligence;

    // Constructor
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
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
}
