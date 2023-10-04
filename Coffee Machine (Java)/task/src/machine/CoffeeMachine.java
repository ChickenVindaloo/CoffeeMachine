package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        menu(water, milk, beans, cups, money);
    }

   public static void status(int water, int milk, int beans, int cups, int money) {
       System.out.println();
       System.out.println("The coffee machine has:");
       System.out.println(water + " ml of water");
       System.out.println(milk + " ml of milk");
       System.out.println(beans + " g of coffee beans");
       System.out.println(cups + " disposable cups");
       System.out.println("$" + money + " of money");

       menu(water, milk, beans, cups, money);
   }

    public static void menu(int water, int milk, int beans, int cups, int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        switch (scanner.next()) {
            case "buy" -> buy(water, milk, beans, cups, money);
            case "fill" -> fill(water, milk, beans, cups, money);
            case "take" -> take(water, milk, beans, cups, money);
            case "remaining" -> status(water, milk, beans, cups, money);
            case "exit" -> {
                System.exit(0);
            }
            default -> {
            }
        }
    }

    public static void buy(int water, int milk, int beans, int cups, int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (scanner.next()) {
            case "1" -> {
                if (water >= 250 && beans >= 16 && cups > 0) {
                    water = water - 250;
                    beans = beans - 16;
                    cups--;
                    money = money + 4;
                } else {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (beans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else {
                        System.out.println("Sorry, not enough cups");
                    }
                }
            }
            case "2" -> {
                if (water >= 350 && milk >= 75 && beans >= 20 && cups > 0) {
                    water = water - 350;
                    milk = milk - 75;
                    beans = beans - 20;
                    cups--;
                    money = money + 7;
                } else {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk");
                    } else if (beans < 20) {
                        System.out.println("Sorry, not enough coffee beans");
                    } else {
                        System.out.println("Sorry, not enough cups");
                    }
                }
            }
            case "3" -> {
                if (water >= 200 && milk >= 100 && beans >= 12 && cups > 0) {
                    water = water - 200;
                    milk = milk - 100;
                    beans = beans - 12;
                    cups--;
                    money = money + 6;
                } else {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk");
                    } else if (beans < 12) {
                        System.out.println("Sorry, not enough coffee beans");
                    } else {
                        System.out.println("Sorry, not enough cups");
                    }
                }
            }
            case "back" -> {
                menu(water, milk, beans, cups, money);
            }
            default -> {
            }
        }

        menu(water, milk, beans, cups, money);
    }

    public static void fill(int water, int milk, int beans, int cups, int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write how many ml of water you want to add:");
        water = water + scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk = milk + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans = beans + scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups = cups + scanner.nextInt();

        menu(water, milk, beans, cups, money);
    }

    public static void take(int water, int milk, int beans, int cups, int money) {
        System.out.println("I gave you $" + money);
        money = 0;

        menu(water, milk, beans, cups, money);
    }
}
