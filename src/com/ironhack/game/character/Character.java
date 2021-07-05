package com.ironhack.game.character;

public abstract class Character { // This class can be abstract since all Characters will be Warriors or Wizards

    // Instance fields
    private int id;
    private static int idCounter = 1;
    private String name;
    private int hp;
    private boolean isAlive = true;

    // Constructor - isAlive defaults to true since all newly created characters are alive
    public Character(String name, int hp) {
        setName(name);
        setHp(hp);
        id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        if(this.getHp() <= 0) {
            this.isAlive = false;
            return false;
        }
        return true;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void defaultAttack(Character opponent) {
       // Overridden by sub-classes
    }

    // toString()
    @Override
    public String toString() {
        return "ID: "+id+" name: "+name+" |HP:"+hp;
    }
}
