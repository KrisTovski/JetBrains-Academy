package machine;

public enum CoffeeType {
    ESPRESSO("1", 250, 0, 16, 4),
    LATTE("2", 350, 75, 20, 7),
    CAPPUCCINO("3", 200, 100, 12, 6),
    NO_COFFEE("back", 0, 0, 0, 0);

    String option;
    int water;
    int milk;
    int beans;
    int money;

    CoffeeType(String option, int water, int milk, int beans, int money) {
        this.option = option;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    public String getOption() {
        return option;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getMoney() {
        return money;
    }

    public static CoffeeType findByOptions(String opt) {
        for (CoffeeType option : values()) {
            if (opt.equals(option.option)) {
                return option;
            }
        }
        return null;
    }
}
