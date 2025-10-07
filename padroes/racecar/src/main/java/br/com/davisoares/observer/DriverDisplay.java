package br.com.davisoares.observer;

public class DriverDisplay implements TelemetryMonitor {
    private final String driverName;

    public DriverDisplay(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public void update(String data) {
        System.out.printf("Driver %s sees telemetry: %s%n",
                driverName, data);
    }
}
