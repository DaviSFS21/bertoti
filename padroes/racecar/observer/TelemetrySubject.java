package racecar.observer;

import java.util.ArrayList;
import java.util.List;

public class TelemetrySubject {
    private final List<TelemetryMonitor> observers = new ArrayList<>();
    private String telemetryData;

    public void addObserver(TelemetryMonitor observer) {
        observers.add(observer);
    }

    public void removeObserver(TelemetryMonitor observer) {
        observers.remove(observer);
    }

    public void setTelemetryData(String data) {
        this.telemetryData = data;
        notifyObservers();
    }

    private void notifyObservers() {
        for (TelemetryMonitor observer : observers) {
            observer.update(telemetryData);
        }
    }
}
