public class Tracer extends Human {
    private int numBullets;

    public Tracer(Gamertag g, int h, int ms, boolean ultimate, int bullets) {
        super(g, h, ms, ultimate);
        this.numBullets = bullets;
    }

    public void shoot() {
        numBullets -= 25;
        Monster.hurtMonster(20);
    }

    public void healSelf() {
        setHealth(getHealth() + 20);
    }

    @Override
    public void ultimate() {
        if (isUltimateAttack()==true) {
            Monster.hurtMonster(50);
            System.out.println("You used your ultimate attack! Tracer attacks the monster with a bunch of bullets!");
            setUltimateAttack(false);
        }
        else {
            System.out.println("It has not been 3 or more turns. You can't use your ultimate yet.");
        }

    }

    //getter and setter methods
    public int getNumBullets() {
        return numBullets;
    }

    public void setNumBullets(int a) {
        this.numBullets=a;
    }

}
