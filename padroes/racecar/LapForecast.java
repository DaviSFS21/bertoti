package racecar;

enum TyreType {
    SOFT,
    MEDIUM,
    HARD
}
interface Strategy {
    int execute(TyreType tyre);
}

class AggressiveStrategy implements Strategy {
    @Override
    public int execute(TyreType tyre) {
        int baseLapForecast = 30;

        if (tyre == TyreType.SOFT) {
            baseLapForecast -= 20;
        } else if (tyre == TyreType.MEDIUM) {
            baseLapForecast -= 10;
        } else if (tyre == TyreType.HARD) {
            baseLapForecast += 0;
        }

        return baseLapForecast;
    }
}

class AverageStrategy implements Strategy {
    @Override
    public int execute(TyreType tyre) {
        int baseLapForecast = 30;

        if (tyre == TyreType.SOFT) {
            baseLapForecast -= 10;
        } else if (tyre == TyreType.MEDIUM) {
            baseLapForecast += 0;
        } else if (tyre == TyreType.HARD) {
            baseLapForecast += 10;
        }

        return baseLapForecast;
    }
}

class DefensiveStrategy implements Strategy {
    @Override
    public int execute(TyreType tyre) {
        int baseLapForecast = 30;

        if (tyre == TyreType.SOFT) {
            baseLapForecast -= 5;
        } else if (tyre == TyreType.MEDIUM) {
            baseLapForecast += 5;
        } else if (tyre == TyreType.HARD) {
            baseLapForecast += 15;
        }

        return baseLapForecast;
    }
}

public class LapForecast {
    private final Strategy strategy;

    public LapForecast(Strategy strategy, String style) {
        switch (style) {
            case "Aggressive" -> this.strategy = new AggressiveStrategy();
            case "Average" -> this.strategy = new AverageStrategy();
            case "Defensive" -> this.strategy = new DefensiveStrategy();
            default -> throw new IllegalArgumentException("Unsupported strategy style");
        }
    }

    public double executeStrategy(TyreType tyre, int fuelLoad) {
        return strategy.execute(tyre);
    }
}
