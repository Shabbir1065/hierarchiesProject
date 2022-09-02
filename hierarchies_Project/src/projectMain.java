import java.util.Scanner;

public class projectMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int turnCounter1 = 0;
        int turnCounter2 = 0;

        //creating Gamertag
        System.out.println("What is your name?");
        String name = in.next();

        System.out.println("What is your favorite number?");
        int favNum = in.nextInt();

        Gamertag character = new Gamertag(name, favNum);

        System.out.println("Hello "+name+"! Your gamertag is now "+character +". Welcome to Underwatch! Please choose your character!\n1. Genji\n2. Farah\n3. Hanzo\n4. Tracer");
        int choice = in.nextInt();

        while (choice>4 || choice<0) {
            System.out.println("Please input a number between 1 and 4.");
            choice = in.nextInt();
        }

        Monster m1 = new Monster (150, 25);

        //Code for Genji Character
        if (choice == 1) {
            System.out.println("You have chosen Genji! It is time to fight the monster.\nGenji is able to shoot his shurikens, use his sword, use a repair box available every 4 turns or use an ultimate attack available every 3 turns.\nLet's play!");
            Genji g1 = new Genji (character, 100, 9, false, 25, 9);

            //Game loop continues until either player or monster dies
            while (Monster.monsterHealth!=0 && g1.getHealth()!=0) {
                turnCounter1+=1;
                turnCounter2+=1;
                //Declares if ultimate is available
                if (turnCounter1 >= 3) {
                    System.out.println("Your ultimate is available this turn!");
                }

                //Declares if repair box is available
                if (turnCounter2 >= 4) {
                    System.out.println("Your repair box is available this turn!");
                }

                System.out.println("\n\nWhat attack would you like to do?\n1. Shoot Shuriken\n2. Sword attack\n3. Ultimate attack\n4. Repair");
                choice = in.nextInt();

                //Attack choices
                if (choice == 1) {
                    if (g1.getNumShurikens()==0) {
                        System.out.println("Oh no! you don't have enough shurikens! You reloaded.");
                        g1.setNumShurikens(9);
                    }
                    else {
                        g1.shootShuriken();
                        System.out.println(m1);
                    }
                }
                else if (choice ==2) {
                    g1.swordAttack();
                    System.out.println(m1);
                }

                else if (choice == 3) {
                    if (turnCounter1>= 3) {
                        g1.setUltimateAttack(true);
                        turnCounter1=0;//reset the value to zero
                    }
                    g1.ultimate();
                    System.out.println(m1);
                }

                else if (choice == 4) {
                    if (turnCounter2>=4) {
                        g1.repair();
                        turnCounter2=0;//reset the value to zero
                    }
                    else {
                        System.out.println("Repair is unavailable right now.");
                    }
                }

                //You win!
                if (Monster.monsterHealth==0) {
                    System.out.println("\nCongratulations! You have won the game!");
                }

                //monster attacks
                else {
                    System.out.println("\nThe Monster has gotten angry! He attacks you!");
                    g1.decreaseHP(Monster.monsterAttack);
                }
            }
        }//end of Genji if statement

        //Code for Farah character
        else if (choice == 2) {
            System.out.println("You have chosen Farah! It is time to fight the monster.\nFarah is able to shoot her missles, use her sonic fist, use a repair box available every 4 turns or use an ultimate attack available every 3 turns.\nLet's play!");
            Farah f1 = new Farah (character, 100, 5, false, 25, 5);

            //Game loop continues until either player or monster dies
            while (Monster.monsterHealth!=0 && f1.getHealth()!=0) {
                turnCounter1+=1;
                turnCounter2+=1;

                //Declares if ultimate is available
                if (turnCounter1 >= 3) {
                    System.out.println("Your ultimate is available this turn!");
                }

                //Declares if repair box is available
                if (turnCounter2 >= 4) {
                    System.out.println("Your repair box is available this turn!");
                }

                System.out.println("\n\nWhat attack would you like to do?\n1. Shoot Missile\n2. Sonic fist\n3. Ultimate attack\n4. Repair");
                choice = in.nextInt();

                //Attack choices
                if (choice == 1) {
                    if (f1.getNumMissiles() == 0) {
                        System.out.println("Oh no! you don't have enough missiles! You reloaded.");
                        f1.setNumMissiles(5);
                    }
                    else {
                        f1.shootMissile();
                        System.out.println(m1);
                    }
                }

                else if (choice == 2) {
                    f1.sonicFist();
                    System.out.println(m1);
                }

                else if (choice == 3) {
                    if (turnCounter1>= 3) {
                        f1.setUltimateAttack(true);
                        turnCounter1=0;
                    }
                    f1.ultimate();
                    System.out.println(m1);
                }

                else if (choice == 4) {
                    if (turnCounter2>=4) {
                        f1.repair();
                        turnCounter2=0;//reset the value to zero
                    }
                    else {
                        System.out.println("Repair is unavailable right now.");
                    }
                }

                //You win!
                if (Monster.monsterHealth==0) {
                    System.out.println("\nCongratulations! You have won the game!");
                }

                //monster attacks
                else {
                    System.out.println("\nThe Monster has gotten angry! He attacks you!");
                    f1.decreaseHP(Monster.monsterAttack);
                }
            }
        }//End of Farah if statement

        //Code for Hanzo Character
        else if (choice == 3) {
            System.out.println("You have chosen Hanzo! It is time to fight the monster.\nHanzo is able to shoot multiple arrows, snipe the target, use a potion available every 3 turns or use an ultimate attack available every 3 turns.\nLet's play!");
            Hanzo h1 = new Hanzo (character, 100, 9, false, 9);

            //Game loop continues until either player or monster dies
            while (Monster.monsterHealth!=0 && h1.getHealth()!=0) {
                turnCounter1+=1;
                turnCounter2+=1;

                //Declares if ultimate is available
                if (turnCounter1 >= 3) {
                    System.out.println("Your ultimate is available this turn!");
                }

                //Declares if potion is available
                if (turnCounter2 >= 3) {
                    System.out.println("Potion is available this turn!");
                }

                System.out.println("\n\nWhat attack would you like to do?\n1. Shoot multiple arrows\n2. Snipe\n3. Ultimate attack\n4. drink potion");
                choice = in.nextInt();

                //Attack choices
                if (choice == 1) {
                    if (h1.getNumArrows() == 0) {
                        System.out.println("Oh no! you don't have enough arrows! You reloaded.");
                        h1.setNumArrows(9);
                    }
                    else {
                        h1.multiAttack();
                        System.out.println(m1);
                    }
                }

                else if (choice == 2) {
                    h1.snipe();
                    System.out.println(m1);
                }

                else if (choice == 3) {
                    if (turnCounter1>= 3) {
                        h1.setUltimateAttack(true);
                        turnCounter1=0;
                    }
                    h1.ultimate();
                    System.out.println(m1);
                }

                else if (choice == 4) {
                    if (turnCounter2>= 3) {
                        h1.drinkpotion();
                        turnCounter2=0;
                    }
                    else {
                        System.out.println("Potion is unavailable this turn");
                    }
                }

                //You win!
                if (Monster.monsterHealth==0) {
                    System.out.println("\\nCongratulations! You have won the game!");
                }

                //monster attacks
                else {
                    System.out.println("\nThe Monster has gotten angry! He attacks you!");
                    h1.decreaseHP(Monster.monsterAttack);
                }
            }
        }//End of Hanzo if statement

        //Code for Tracer Character
        else {
            System.out.println("You have chosen Tracer! It is time to fight the monster.\nTracer is able to shoot her gun, heal herself by 20 points, use a potion available every 3 turns or use an ultimate attack available every 3 turns.\nLet's play!");
            Tracer t1 = new Tracer (character, 100, 100, false, 100);

            //Game loop continues until either player or monster dies
            while (Monster.monsterHealth!=0 && t1.getHealth()!=0) {
                turnCounter1+=1;
                turnCounter2+=1;

                //Declares if ultimate is available
                if (turnCounter1 >= 3) {
                    System.out.println("Your ultimate is available this turn!");
                }

                //Declares if potion is available
                if (turnCounter2 >= 3) {
                    System.out.println("Potion is available this turn!");
                }

                System.out.println("\n\nWhat attack would you like to do?\n1. Shoot\n2. Self-heal\n3. Ultimate attack\n4. Drink potion");
                choice = in.nextInt();

                //Attack choices
                if (choice == 1) {
                    if (t1.getNumBullets() == 0) {
                        System.out.println("Oh no! you don't have enough bullets! You reloaded.");
                        t1.setNumBullets(100);
                    }
                    else {
                        t1.shoot();
                        System.out.println(m1);
                    }
                }

                if (choice == 2) {
                    t1.healSelf();
                    System.out.println(m1);
                }

                if (choice == 3) {
                    if (turnCounter1>= 3) {
                        t1.setUltimateAttack(true);
                        turnCounter1=0;
                    }
                    t1.ultimate();
                    System.out.println(m1);
                }

                else if (choice == 4) {
                    if (turnCounter2>= 3) {
                        t1.drinkpotion();
                        turnCounter2=0;
                    }
                    else {
                        System.out.println("Potion is unavailable this turn");
                    }
                }

                //You win!
                if (Monster.monsterHealth==0) {
                    System.out.println("\\nCongratulations! You have won the game!");
                }

                //monster attacks
                else {
                    System.out.println("\nThe Monster has gotten angry! He attacks you!");
                    t1.decreaseHP(Monster.monsterAttack);
                }
            }
        }//End of Tracer if statement

    }
}
