package com.ironhack.game.battle.mockup;

import com.ironhack.game.battle.interfaces.Fightable;

public abstract class Character implements Fightable { // This class can be abstract since all Characters will be Warriors or Wizards

    // Instance fields
    private String id; // As a string to be able to format "001" instead of "1"
    private String name;
    private int hp;
    private boolean isAlive;

    // Constructor - isAlive defaults to true since all newly created characters are alive
    public Character(String id, String name, int hp) {
        setId(id);
        setName(name);
        setHp(hp);
        this.isAlive = true;
    }

    // id setter and getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // name setter and getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // hp setter and getter
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // isAlive setter and getter
    public boolean isAlive() {
        return getHp()>0;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    // toString()

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive() +
                '}';
    }
}
