public class Gamertag {
    private String name;
    private int favNumber;

    public Gamertag (String n, int number) {
        this.name = n;
        this.favNumber=number;
    }

    public String toString() {
        return this.name+this.favNumber;
    }

}