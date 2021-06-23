import java.util.Random;

public class Wizard {
    private int mana;
    private int Intelligence;
    private int Fireball;
    private int Staffhit;


    public Wizard(int mana, int intelligence, int fireball, int staffhit) {
        this.mana = mana;
        Intelligence = intelligence;
        Fireball = fireball;
        Staffhit = staffhit;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public int getFireball() {
        return Fireball;
    }

    public void setFireball(int fireball) {
        Fireball = fireball;
    }

    public int getStaffhit() {
        return Staffhit;
    }

    public void setStaffhit(int staffhit) {
        Staffhit = staffhit;
    }
}
