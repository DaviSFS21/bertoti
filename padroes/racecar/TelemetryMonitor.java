package racecar;

interface TelemetryMonitor {
    void update(String data);
}

class EngineerDisplay implements TelemetryMonitor {
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

class PitWallDisplay implements TelemetryMonitor {
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

class DriverDisplay implements TelemetryMonitor {
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
