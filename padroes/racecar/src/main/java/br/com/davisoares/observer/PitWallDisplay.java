package br.com.davisoares.observer;

public class PitWallDisplay implements TelemetryMonitor {
    private final String displayId;

    public PitWallDisplay(String displayId) {
        this.displayId = displayId;
    }

    @Override
    public void update(String data) {
        System.out.printf("Pit Wall Display %s shows telemetry: %s%n",
                displayId, data);
    }
}
