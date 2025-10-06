package racecar.strategy;

public class AggressiveStrategy implements Strategy {
    @Override
    public int execute(TireType tyre) {
        int baseLapForecast = 30;

        if (tyre == TireType.SOFT) {
            baseLapForecast -= 20;
        } else if (tyre == TireType.MEDIUM) {
            baseLapForecast -= 10;
        } else if (tyre == TireType.HARD) {
            baseLapForecast += 0;
        }

        return baseLapForecast;
    }
}
