package com.ironhack.game.character;

public class Warrior extends Character implements Attacker {

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

    //---- ATTACKER INTERFACE METHODS
    public void defaultAttack(Character opponent) {
        if(this.getStamina() < 5) {
            secondaryAttack(opponent);
        } else {
            opponent.setHp(opponent.getHp() - this.getStrength());
            this.setStamina(this.getStamina() - 5);
        }
    }
    public void secondaryAttack(Character opponent) {
        opponent.setHp(opponent.getHp() - this.getStrength() / 2);
        this.setStamina(this.getStamina() + 1);
    }
}







