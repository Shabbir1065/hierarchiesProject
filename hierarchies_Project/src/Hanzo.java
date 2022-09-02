import java.util.Random;

public class Hanzo extends Human {
    private int numArrows;
    Random objGenerator = new Random();

    public Hanzo(Gamertag g, int h, int ms, boolean ultimate, int arrows) {
        super(g, h, ms, ultimate);
        this.numArrows = arrows;
    }

    public void multiAttack() {
        numArrows -= 3;
        int chance = objGenerator.nextInt(3);
        if (chance == 1) {
            Monster.hurtMonster(10);
            System.out.println("Only one of your arrows hit the monster!");
        }
        else if (chance == 2) {
            Monster.hurtMonster(20);
            System.out.println("Two of your arrows hit the monster!");
        }

        else {
            Monster.hurtMonster(30);
            System.out.println("All three of your arrows hit the monster!");
        }
    }

    public void snipe() {
        Monster.hurtMonster(25);
        System.out.println("You sniped the monster!");
    }

    @Override
    public void ultimate() {
        if (isUltimateAttack()==true) {
            Monster.hurtMonster(50);
            System.out.println("You used your ultimate attack! Hanzo attacks the monster with a barrage of arrows!");
            setUltimateAttack(false);
        }
        else {
            System.out.println("It has not been 3 or more turns. You can't use your ultimate yet.");
        }
    }

    //getter and setter methods
    public int getNumArrows() {
        return numArrows;
    }

    public void setNumArrows(int a) {
        this.numArrows= a;
    }

}
