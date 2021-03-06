package characters;

public abstract class Player {

    private String name;
    private int maxHP;
    private int currentHP;
    private String catchPhrase;
    private int gold;

    public Player(String name, int maxHP, String catchPhrase) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.catchPhrase = catchPhrase;
        this.gold = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public String getCatchPhrase() {
        return this.catchPhrase;
    }

    public int getGold() {
        return this.gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void loseHP(int damage) {
        this.currentHP -= damage;
    }

    public void gainHP(int heal) {
        if(heal + this.currentHP < this.maxHP) {
            this.currentHP += heal;
        }
        else {
            this.currentHP = this.maxHP;
        }
    }
}
