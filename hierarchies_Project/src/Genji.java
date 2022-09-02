import java.util.Random;

public class Genji extends Robot {
    private int numShurikens;
    Random objGenerator = new Random();

    public Genji(Gamertag g, int h, int ms, boolean ultimate, int a, int shurikens) {
        super(g, h, ms, ultimate, a);
        this.setNumShurikens(shurikens);
    }

    //This method allows the user to shoot three shurikens where 1-3 of them actually hit the target
    public void shootShuriken() {
        setNumShurikens(getNumShurikens() - 3);
        int chance = objGenerator.nextInt(3);
        if (chance == 1) {
            Monster.hurtMonster(10);
            System.out.println("Only one shuriken managed to hit the monster!");
        }
        else if (chance == 2) {
            Monster.hurtMonster(20);
            System.out.println("Only two shurikens managed to hit the monster!");
        }

        else {
            Monster.hurtMonster(30);
            System.out.println("All of the shurikens managed to hit the monster!");
        }
    }

    //This is another attack method to hurt the monster but the damage varies more
    public void swordAttack() {
        int chance = objGenerator.nextInt(3);
        if (chance == 1) {
            Monster.hurtMonster(5);
            System.out.println("You just grazed the monster!");
        }
        else if (chance == 2) {
            Monster.hurtMonster(10);
            System.out.println("You cut the monster with your sword!");
        }

        else {
            Monster.hurtMonster(40);
            System.out.println("You stabbed the monster and hit him critically!");
        }
    }

    @Override
    public void ultimate() {
        if (isUltimateAttack()==true) {
            Monster.hurtMonster(55);
            System.out.println("You used your ultimate attack! Genji goes up to the monster and attacks him with incredible speed!");
            setUltimateAttack(false);
        }
        else {
            System.out.println("It has not been 3 or more turns. You can't use your ultimate yet.");
        }
    }

    //Getter and setter methods
    public int getNumShurikens() {
        return numShurikens;
    }

    public void setNumShurikens(int numShurikens) {
        this.numShurikens = numShurikens;
    }

}
