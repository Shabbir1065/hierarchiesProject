import java.util.Random;

public class Farah extends Robot {
    private int numMissiles;
    Random objGenerator = new Random();

    public Farah(Gamertag g, int h, int ms, boolean ultimate, int a, int missiles) {
        super(g, h, ms, ultimate, a);
        this.numMissiles = missiles;
    }

    public void shootMissile() {
        numMissiles -= 1;
        int chance = objGenerator.nextInt(3);
        if (chance == 1) {
            Monster.hurtMonster(10);
            System.out.println("The monster almost dodged your attack!");
        }
        else if (chance == 2) {
            Monster.hurtMonster(20);
            System.out.println("The monster barely dodged your attack!");
        }

        else {
            Monster.hurtMonster(40);
            System.out.println("The monster was critically hit by your missile!");
        }
    }

    public void sonicFist() {
        Monster.hurtMonster(25);
        System.out.println("You hit the monster with your sonic fist!");
    }

    public void ultimate() {
        if (isUltimateAttack()==true) {
            Monster.hurtMonster(60);
            System.out.println("You used your ultimate attack! Farah attacks the monster with a barrage of missiles!");
            setUltimateAttack(false);
        }
        else {
            System.out.println("It has not been 3 or more turns. You can't use your ultimate yet.");
        }
    }

    //Getter and setter methods
    public int getNumMissiles() {
        return numMissiles;
    }

    public void setNumMissiles(int numMissiles) {
        this.numMissiles = numMissiles;
    }

}
