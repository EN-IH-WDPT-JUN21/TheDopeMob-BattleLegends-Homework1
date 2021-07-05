package com.ironhack.game.character;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
            System.out.println(getName()+" attacks "+opponent.getName()+" with a Heavy Attack for "+getStrength()+" damage. Opponent has "+opponent.getHp()+" hp left.");
            this.setStamina(this.getStamina() - 5);
            System.out.println(getName()+" loses 5 stamina, total stamina left: "+stamina);
        }
    }
    public void secondaryAttack(Character opponent) {
        //Calculating damage so we can use it in sout command easier.
        int calculateDamage = new BigDecimal(String.valueOf(getStrength())).divide(new BigDecimal("2"),0, RoundingMode.FLOOR).intValue();
        opponent.setHp(opponent.getHp() - calculateDamage);
        System.out.println(getName()+" attacks "+opponent.getName()+" with a Weak Attack for "+calculateDamage+" damage. Opponent has "+opponent.getHp()+" hp left.");
        this.setStamina(this.getStamina() + 1);
        System.out.println(getName()+" recover 1 stamina, total stamina amount: "+stamina);
    }

    @Override
    public String toString() {
        return super.toString()+" |"+getClass().getSimpleName()+ " |Strength:"+strength+" |Stamina:"+stamina;
    }
}







