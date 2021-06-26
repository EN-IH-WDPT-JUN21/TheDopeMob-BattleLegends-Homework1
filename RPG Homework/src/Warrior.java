public class Warrior {
    private int stamina;
    private int strength;
    private int heavyattack;
    private int weakattack;

    public Warrior(int stamina, int strength, int heavyattack, int weakattack) {
        this.stamina = stamina;
        this.strength = strength;
        heavyattack = heavyattack;
        weakattack = weakattack;

    }

    public int getStamina() {return stamina;}

    public void setStamina(int stamina) {this.stamina = stamina;}

    public int getStrength() {return strength;}

    public void setStrength(int strength) {this.strength = strength;}

    public int getHeavyattack() {return heavyattack;}

    public void setHeavyattack(int heavyattack) {this.heavyattack = heavyattack; }

    public int getWeakattack() {return weakattack;}

    public void setWeakattack(int weakattack) {this.weakattack = weakattack; }
}
