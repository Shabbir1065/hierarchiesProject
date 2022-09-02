public abstract class Human extends Player {

    public Human(Gamertag g, int h, int ms, boolean ultimate) {
        super(g, h, ms, ultimate);

    }

    public void drinkpotion () {
        setHealth(getHealth() + 50);
        System.out.println("You drank a potion and healed 50 points!");
    }

}
