package machine;
import java.util.Scanner;
public class CoffeeMachine {

    private Scanner scanner = new Scanner(System.in);

    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int disposableCups = 9;
    private int money = 550;


    public static void main(String[] args){
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean status;
        do {
            status = coffeeMachine.Action();
        }
        while (status);


    }

    public void PrintState(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", this.water);
        System.out.printf("%d of milk\n", this.milk);
        System.out.printf("%d of coffee beans\n", this.coffee);
        System.out.printf("%d of disposable cups\n", this.disposableCups);
        System.out.printf("%d of money", this.money);
        System.out.println(" ");
        System.out.println(" ");
    }

    public void Buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next();
        if (choice.equals("back")) return;
        int water = 0;
        int milk = 0;
        int beans = 0;
        int money = 0;
        switch (Integer.valueOf(choice)) {
            case 1: {
                water = 250;
                milk = 0;
                beans = 16;
                money = 4;
                break;
            }
            case 2: {
                water = 350;
                milk = 75;
                beans = 20;
                money = 7;
                break;
            }
            case 3: {
                water = 200;
                milk = 100;
                beans = 12;
                money = 6;
                break;
            }
            default: {
                break;
            }
        }
        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffee < beans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.coffee -= beans;
            this.disposableCups--;
            this.money += money;
        }
    }

    public void Fill(){
        System.out.println("Write how many ml of water do you want to add: ");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        this.coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.disposableCups += scanner.nextInt();
        System.out.println(" ");
    }

    public void Take(){
        System.out.printf("I gave you $%d", money);
        System.out.println(" ");
        this.money = 0;
    }

    public boolean Action(){
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        switch (action) {
            case "buy": {
                this.Buy();
                break;
            }
            case "fill": {
                this.Fill();
                break;
            }
            case "take": {
                this.Take();
                break;
            }
            case "remaining": {
                this.PrintState();
                break;
            }
            case "exit": {
                return false;
            }
            default: {
                break;
            }
        }
        return true;
    }

}