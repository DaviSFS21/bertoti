package racecar;

import java.util.List;

interface CarComponent {
    String getName();
    double getWeight();
}

class Component implements CarComponent {
    private final String name;
    private final double weight;

    public Component(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

public class Assembly implements CarComponent {
    String name;
    List<CarComponent> components;

    public Assembly(String name) {
        this.name = name;
    }

    public void addComponent(CarComponent component) {
        components.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return components.stream().mapToDouble(CarComponent::getWeight).sum();
        }
}
