package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int waterInMachine = 400;
    static int milkInMachine = 540;
    static int beansInMachine = 120;
    static int cupsInMachine = 9;
    static int moneyInMachine = 550;

    public static void main(String[] args) {

        mainLoop();

    }

    private static void mainLoop() {
        do {
            printOptions();
        } while (true);
    }

    private static void printOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();


        switch (Actions.findByValue(action)) {
            case BUY:
                buyAction();
                break;
            case FILL:
                fillAction();
                break;
            case TAKE:
                takeAction();
                break;
            case REMAINING:
                printMachineStatus();
                break;
            case EXIT:
                exit();
                break;

        }

    }

    private static void exit() {
        System.exit(0);
    }

    private static void takeAction() {
        System.out.println("I gave you " + moneyInMachine);
        moneyInMachine = 0;
    }

    private static void fillAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        waterInMachine = waterInMachine + scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milkInMachine = milkInMachine + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beansInMachine = beansInMachine + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cupsInMachine = cupsInMachine + scanner.nextInt();
    }

    private static void buyAction() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("What do you want to buy? "
                + CoffeeType.ESPRESSO + " - espresso, "
                + CoffeeType.LATTE + " - latte, "
                + CoffeeType.CAPPUCCINO + " - cappuccino, "
                + CoffeeType.NO_COFFEE + " - to main menu:");
        switch (CoffeeType.findByOptions(option)) {

            case ESPRESSO:
                buyingCoffee(CoffeeType.ESPRESSO);
                break;
            case LATTE:
                buyingCoffee(CoffeeType.LATTE);
                break;
            case CAPPUCCINO:
                buyingCoffee(CoffeeType.CAPPUCCINO);
                break;
            case NO_COFFEE:
                printOptions();
                break;
        }
    }

    private static void buyingCoffee(CoffeeType coffeeType) {
        if (waterInMachine < coffeeType.water) {
            System.out.println("Sorry, not enough water!");
        } else if (milkInMachine < coffeeType.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (beansInMachine < coffeeType.beans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cupsInMachine == 0) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= coffeeType.water;
            milkInMachine -= coffeeType.milk;
            beansInMachine -= coffeeType.beans;
            cupsInMachine--;
            moneyInMachine += coffeeType.money;
        }

    }


    private static void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterInMachine + " of water");
        System.out.println(milkInMachine + " of milk");
        System.out.println(beansInMachine + " of coffee beans");
        System.out.println(cupsInMachine + " of disposable cups");
        System.out.println(moneyInMachine + " money");
    }
}
