package br.com.davisoares.observer;

public class EngineerDisplay implements TelemetryMonitor {
    private final String engineerName;

    public EngineerDisplay(String engineerName) {
        this.engineerName = engineerName;
    }

    @Override
    public void update(String data) {
        System.out.printf("Engineer %s received telemetry update: %s%n",
                engineerName, data);
    }
}
