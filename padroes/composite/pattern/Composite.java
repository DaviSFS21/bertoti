import java.util.ArrayList;

interface Component {
    void showPrice();
    double showTotal();
}

static class Leaf implements Component {
    private final String name;
    private final double price;

    public Leaf(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.printf("Item: %s, Price: %.2f%n", name, price);
    }

    @Override
    public double showTotal() {
        return price;
    }
}

static class GroupComposite implements Component {
    private final String name;
    private final java.util.List<Component> components = new ArrayList<>();

    public GroupComposite(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void showPrice() {
        System.out.printf("Group: %s%n", name);
        for (Component component : components) {
            component.showPrice();
        }
    }

    @Override
    public double showTotal() {
        double total = 0;
        for (Component component : components) {
            total += component.showTotal();
        }
        return total;
    }
}

void main() {
    Leaf item1 = new Leaf("Item 1", 10.0);
    Leaf item2 = new Leaf("Item 2", 20.0);
    Leaf item3 = new Leaf("Item 3", 30.0);

    GroupComposite group1 = new GroupComposite("Group 1");
    group1.addComponent(item1);
    group1.addComponent(item2);

    GroupComposite group2 = new GroupComposite("Group 2");
    group2.addComponent(item3);
    group2.addComponent(group1);

    group2.showPrice();
    System.out.printf("Total Price: %.2f%n", group1.showTotal());
    System.out.printf("Total Price: %.2f%n", group2.showTotal());
}
