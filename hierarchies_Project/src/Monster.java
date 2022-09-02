
import java.util.Random;

public class Monster {
    static int monsterHealth;
    static int monsterAttack;
    Random objGenerator = new Random();

    public Monster(int monsterHP, int monsterHit) {
        Monster.monsterHealth = monsterHP;
        Monster.monsterAttack = monsterHit;
    }

    public static void hurtMonster(int damage) {
        monsterHealth-=damage;
        if (monsterHealth<0) {
            monsterHealth = 0;
        }
    }

    public String toString() {
        return "Monster health: " + Monster.monsterHealth;
    }

}
