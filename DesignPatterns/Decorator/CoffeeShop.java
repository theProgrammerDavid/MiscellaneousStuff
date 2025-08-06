abstract class Beverage {
    private String description;

    public Beverage(String description) {
        super();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        super("House Blend");
    }

    @Override
    public double cost() {
        return 250;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        super("Dark Roast");
    }

    @Override
    public double cost() {
        return 300;
    }
}

abstract class AddOn extends Beverage {
    protected Beverage beverage;

    public AddOn(String description, Beverage bev) {
        super(description);
        this.beverage = bev;
    }

    public abstract String getDescription();
}

class Sugar extends AddOn {
    public Sugar(Beverage b) {
        super("Sugar", b);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "With Sugar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 50;
    }
}

class Milk extends AddOn {
    public Milk(Beverage b) {
        super("Milk", b);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "With Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 100;
    }
}

class CoffeeShop {
    public static void main(String[] args) {

        HouseBlend houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription());

        Milk milkAddon = new Milk(houseBlend);
        System.out.println(milkAddon.getDescription() + ":" + milkAddon.cost());

        Sugar sugar = new Sugar(houseBlend);
        System.out.println(sugar.getDescription() + ":" + sugar.cost());
    }
}