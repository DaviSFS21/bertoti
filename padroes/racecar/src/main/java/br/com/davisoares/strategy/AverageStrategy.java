package br.com.davisoares.strategy;

public class AverageStrategy implements Strategy {
    @Override
    public int execute(TireType tyre) {
        int baseLapForecast = 30;

        if (tyre == TireType.SOFT) {
            baseLapForecast -= 10;
        } else if (tyre == TireType.MEDIUM) {
            baseLapForecast += 0;
        } else if (tyre == TireType.HARD) {
            baseLapForecast += 10;
        }

        return baseLapForecast;
    }
}
