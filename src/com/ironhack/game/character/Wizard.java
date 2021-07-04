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
            this.setMana(this.getMana() - 5);
        }
    }
    @Override
    public void secondaryAttack(Character opponent) {
        opponent.setHp(opponent.getHp() - 2);
        this.setMana(this.getMana() + 1);
    }

}
