package br.com.davisoares.composite;

import java.util.ArrayList;
import java.util.List;

public class Assembly implements CarComponent {
    private final String name;
    private final List<CarComponent> components;

    public Assembly(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(CarComponent component) {
        components.add(component);
    }

    public void removeComponent(CarComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return components.stream().mapToDouble(CarComponent::getWeight).sum();
    }

    public List<CarComponent> getComponents() {
        return new ArrayList<>(components);
    }
}
