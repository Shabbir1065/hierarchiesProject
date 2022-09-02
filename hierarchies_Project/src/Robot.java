public abstract class Robot extends Player {
    private int armor;

    public Robot(Gamertag g, int h, int ms, boolean ultimate, int a) {
        super(g, h, ms, ultimate);
        this.armor = a;
    }

    public void repair() {
        armor+=50;
        System.out.println("You repaired yourself and now your armor increased by 50 points!");
    }

    public void decreaseHP(int hurt) {
        //making sure armor gets removed first and then health
        if (hurt > armor) {
            setHealth(getHealth()-(hurt-armor));
            armor = 0;
        }
        else {
            armor = armor-hurt;
        }

        //making sure health is never negative
        if (getHealth() < 0) {
            setHealth(0);
        }
        System.out.println("You were attacked and your current armor is now "+armor+" and your health is "+getHealth());
        if (getHealth() == 0) {
            System.out.println ("You have lost the game :(");
        }
    }

}
