public abstract class Player {
    private Gamertag character;
    private int health;
    private int magsize;
    private boolean ultimateAttack;

    public Player (Gamertag g, int h, int ms, boolean ultimate) {
        this.character=g;
        this.health=h;
        this.magsize=ms;
        this.ultimateAttack=ultimate;
    }

    public void decreaseHP(int hurt) {
        setHealth(getHealth()-hurt);
        if (getHealth() < 0) {
            setHealth(0);
        }

        System.out.println("You were attacked and your current health is now "+getHealth());
        if (getHealth() == 0) {
            System.out.println ("You have lost the game :(");
        }
    }

    public abstract void ultimate();

    //Getter and setter methods


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagsize() {
        return magsize;
    }

    public void setMagsize(int magsize) {
        this.magsize = magsize;
    }

    public boolean isUltimateAttack() {
        return ultimateAttack;
    }

    public boolean setUltimateAttack(boolean ultimateAttack) {
        this.ultimateAttack = ultimateAttack;
        return ultimateAttack;
    }

}
