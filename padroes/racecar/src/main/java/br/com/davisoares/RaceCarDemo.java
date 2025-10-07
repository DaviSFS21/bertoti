package br.com.davisoares;

import br.com.davisoares.observer.*;
import br.com.davisoares.strategy.*;
import br.com.davisoares.composite.*;

public class RaceCarDemo {
    public static void main(String[] args) {
        System.out.println("=== RACE CAR DESIGN PATTERNS DEMONSTRATION ===\n");
        demonstrateObserverPattern();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateStrategyPattern();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateCompositePattern();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateIntegratedSystem();
    }
    
    private static void demonstrateObserverPattern() {
        System.out.println("1. OBSERVER PATTERN - Telemetry Monitoring System");
        System.out.println("-".repeat(50));

        TelemetrySubject telemetrySubject = getTelemetrySubject();

        telemetrySubject.setTelemetryData("Engine RPM: 12,500 | Speed: 320 km/h | Fuel: 45L");
        System.out.println();
        telemetrySubject.setTelemetryData("Tire Temperature: Front 85°C, Rear 90°C | Brake Temp: 650°C");
        System.out.println();
        telemetrySubject.setTelemetryData("Lap Time: 1:23.456 | Sector 1: 28.123 | Sector 2: 30.234 | Sector 3: 25.099");
    }

    private static TelemetrySubject getTelemetrySubject() {
        TelemetrySubject telemetrySubject = new TelemetrySubject();

        TelemetryMonitor engineerDisplay = new EngineerDisplay("John Smith");
        TelemetryMonitor pitWallDisplay = new PitWallDisplay("Main Display");
        TelemetryMonitor driverDisplay = new DriverDisplay("Lewis Hamilton");

        // Register observers
        telemetrySubject.addObserver(engineerDisplay);
        telemetrySubject.addObserver(pitWallDisplay);
        telemetrySubject.addObserver(driverDisplay);
        return telemetrySubject;
    }

    private static void demonstrateStrategyPattern() {
        System.out.println("2. STRATEGY PATTERN - Lap Time Forecasting");
        System.out.println("-".repeat(50));
        
        // Test different strategies with different tire types
        TireType[] tireTypes = {TireType.SOFT, TireType.MEDIUM, TireType.HARD};
        String[] strategies = {"Aggressive", "Average", "Defensive"};
        
        for (String strategyName : strategies) {
            System.out.println("\n" + strategyName + " Strategy:");
            LapForecast forecast = new LapForecast(strategyName);
            
            for (TireType tire : tireTypes) {
                double lapTime = forecast.executeStrategy(tire, 100);
                System.out.printf("  %s tires: %.1f seconds%n", tire, lapTime);
            }
        }
    }
    
    private static void demonstrateCompositePattern() {
        System.out.println("3. COMPOSITE PATTERN - Car Component Assembly");
        System.out.println("-".repeat(50));
        
        // Create individual components
        Component engine = new Component("V6 Turbo Engine", 145.0);
        Component transmission = new Component("8-Speed Transmission", 85.0);
        Component chassis = new Component("Carbon Fiber Chassis", 95.0);
        Component frontWing = new Component("Front Wing", 12.0);
        Component rearWing = new Component("Rear Wing", 15.0);
        Component frontSuspension = new Component("Front Suspension", 25.0);
        Component rearSuspension = new Component("Rear Suspension", 28.0);
        
        // Create assemblies
        Assembly powertrain = new Assembly("Powertrain Assembly");
        powertrain.addComponent(engine);
        powertrain.addComponent(transmission);
        
        Assembly aerodynamics = new Assembly("Aerodynamics Package");
        aerodynamics.addComponent(frontWing);
        aerodynamics.addComponent(rearWing);
        
        Assembly suspension = new Assembly("Suspension System");
        suspension.addComponent(frontSuspension);
        suspension.addComponent(rearSuspension);
        
        // Create main car assembly
        Assembly raceCar = new Assembly("Formula 1 Race Car");
        raceCar.addComponent(chassis);
        raceCar.addComponent(powertrain);
        raceCar.addComponent(aerodynamics);
        raceCar.addComponent(suspension);
        
        // Display component information
        System.out.println("Car Assembly Structure:");
        displayAssembly(raceCar, 0);
        
        System.out.printf("\nTotal Car Weight: %.1f kg%n", raceCar.getWeight());
    }
    
    private static void displayAssembly(Assembly assembly, int depth) {
        String indent = "  ".repeat(depth);
        System.out.printf("%s%s (%.1f kg)%n", indent, assembly.getName(), assembly.getWeight());
        
        for (CarComponent component : assembly.getComponents()) {
            if (component instanceof Assembly) {
                displayAssembly((Assembly) component, depth + 1);
            } else {
                System.out.printf("%s  %s (%.1f kg)%n", indent, component.getName(), component.getWeight());
            }
        }
    }
    
    private static void demonstrateIntegratedSystem() {
        System.out.println("4. INTEGRATED SYSTEM - All Patterns Working Together");
        System.out.println("-".repeat(50));
        
        TelemetrySubject telemetrySubject = new TelemetrySubject();
        TelemetryMonitor engineerDisplay = new EngineerDisplay("Race Engineer");
        telemetrySubject.addObserver(engineerDisplay);
        
        LapForecast lapForecast = new LapForecast("Aggressive");
        
        Assembly raceCar = createRaceCar();
        
        System.out.println("Race Simulation Starting...\n");
        
        telemetrySubject.setTelemetryData("Lap 1 - Soft Tires | Strategy: Aggressive");
        double lapTime1 = lapForecast.executeStrategy(TireType.SOFT, 100);
        System.out.printf("Predicted Lap Time: %.1f seconds%n", lapTime1);
        System.out.printf("Car Weight: %.1f kg%n", raceCar.getWeight());
        
        System.out.println();
        
        telemetrySubject.setTelemetryData("Lap 15 - Pit Stop | Medium Tires | Strategy: Average");
        LapForecast newStrategy = new LapForecast("Average");
        double lapTime15 = newStrategy.executeStrategy(TireType.MEDIUM, 50);
        System.out.printf("Predicted Lap Time: %.1f seconds%n", lapTime15);
        
        System.out.println();

        telemetrySubject.setTelemetryData("Lap 30 - Final Stint | Hard Tires | Strategy: Defensive");
        LapForecast finalStrategy = new LapForecast("Defensive");
        double lapTime30 = finalStrategy.executeStrategy(TireType.HARD, 20);
        System.out.printf("Predicted Lap Time: %.1f seconds%n", lapTime30);
        
        System.out.println("\nRace simulation completed!");
    }
    
    private static Assembly createRaceCar() {
        Component engine = new Component("V6 Turbo Engine", 145.0);
        Component chassis = new Component("Carbon Fiber Chassis", 95.0);
        
        Assembly raceCar = new Assembly("Formula 1 Race Car");
        raceCar.addComponent(engine);
        raceCar.addComponent(chassis);
        
        return raceCar;
    }
}
