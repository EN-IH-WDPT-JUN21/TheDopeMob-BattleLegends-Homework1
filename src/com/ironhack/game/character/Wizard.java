package com.ironhack.game.character;

public class Wizard extends Character implements Attacker {

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

    //---- ATTACKER INTERFACE METHODS
    @Override
    public void defaultAttack(Character opponent) {
        if(this.getMana() < 5) {
            secondaryAttack(opponent);
        } else {
            opponent.setHp(opponent.getHp() - this.getIntelligence());
            System.out.println(getName()+" casts  Fireball and attacks "+opponent.getName()+" for "+getIntelligence()+" damage. Opponent has "+opponent.getHp()+" hp left.");
            this.setMana(this.getMana() - 5);
            System.out.println(getName()+" looses 5 mana, total mana left: "+mana);
        }
    }
    @Override
    public void secondaryAttack(Character opponent) {
        opponent.setHp(opponent.getHp() - 2);
        System.out.println(getName()+" attacks "+opponent.getName()+" with a Staff Attack for 2 damage. Opponent has "+opponent.getHp()+" hp left.");
        this.setMana(this.getMana() + 1);
        System.out.println(getName()+" recover 1 mana, total mana amount: "+mana);
    }

    @Override
    public String toString() {
        return super.toString()+" |"+getClass().getSimpleName()+" |Intelligence:"+Intelligence+" |Mana:"+mana;
    }
}
