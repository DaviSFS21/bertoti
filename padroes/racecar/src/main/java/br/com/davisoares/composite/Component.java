package br.com.davisoares.composite;

public class Component implements CarComponent {
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
