public class Character {
int charid;
int hp;
boolean isAlive;

public Character(int charid, int hp, boolean isAlive) {
    this.charid = charid;
    this.hp = hp;
    isAlive = true;

}

    public int getCharid() {
        return charid;
    }

    public void setCharid(int charid) {
        this.charid = charid;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
