package com.ironhack.game.character;

public class Warrior extends Character {

    // Instance fields
    private int stamina;
    private int strength;

    // Constructor
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    // Warrior uses getters and setters for id, name, hp and isAlive from Character
    // stamina getters and setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // strength getters and setters
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {this.strength = strength;}
}







