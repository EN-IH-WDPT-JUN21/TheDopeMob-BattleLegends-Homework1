package com.ironhack.game.battle.mockup;
public class Warrior extends Character {
    //CONSTS
    private final int STAMINA_USAGE = 1;

    // Instance fields
    private int stamina;
    private int strength;

    // Constructor
    public Warrior(String id, String name, int hp, int stamina, int strength) {
        super(id, name, hp);
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

    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public void attack(Character opponent) {
        if (stamina < STAMINA_USAGE)
            System.out.println(getName() + " has no stamina!");
        else {
            System.out.println(getName() + " strikes for " + getStrength()+" power");
            opponent.getHit(getStrength());
        }
    }
}







