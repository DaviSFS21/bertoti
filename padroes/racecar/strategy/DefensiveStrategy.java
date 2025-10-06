package racecar.strategy;

public class DefensiveStrategy implements Strategy {
    @Override
    public int execute(TireType tyre) {
        int baseLapForecast = 30;

        if (tyre == TireType.SOFT) {
            baseLapForecast -= 5;
        } else if (tyre == TireType.MEDIUM) {
            baseLapForecast += 5;
        } else if (tyre == TireType.HARD) {
            baseLapForecast += 15;
        }

        return baseLapForecast;
    }
}
