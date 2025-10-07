package br.com.davisoares.strategy;

public class LapForecast {
    private final Strategy strategy;

    public LapForecast(Strategy strategy) {
        this.strategy = strategy;
    }

    public LapForecast(String style) {
        switch (style) {
            case "Aggressive":
                this.strategy = new AggressiveStrategy();
                break;
            case "Average":
                this.strategy = new AverageStrategy();
                break;
            case "Defensive":
                this.strategy = new DefensiveStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unsupported strategy style: " + style);
        }
    }

    public double executeStrategy(TireType tyre, int fuelLoad) {
        return strategy.execute(tyre);
    }
}
