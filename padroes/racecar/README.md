# RaceCar Project UML (Mermaid)

This module demonstrates multiple design patterns (Observer, Strategy, Composite) around a race car domain. The diagram below summarizes the core classes and their relationships.

```mermaid
classDiagram
  direction LR

  %% ===== Composite (Car assembly) =====
  class CarComponent {
    <<interface>>
    +getName() String
    +getWeight() double
  }
  class Component {
    -name String
    -weight double
    +Component(name, weight)
    +getName() String
    +getWeight() double
  }
  class Assembly {
    -name String
    -components List~CarComponent~
    +Assembly(name)
    +addComponent(component) void
    +removeComponent(component) void
    +getComponents() List~CarComponent~
    +getName() String
    +getWeight() double
  }
  Component ..|> CarComponent
  Assembly ..|> CarComponent
  Assembly "1" *-- "*" CarComponent : contains

  %% ===== Observer (Telemetry) =====
  class TelemetryMonitor {
    <<interface>>
    +update(data String) void
  }
  class TelemetrySubject {
    -observers List~TelemetryMonitor~
    -telemetryData String
    +addObserver(observer) void
    +removeObserver(observer) void
    +setTelemetryData(data String) void
    .. notifyObservers() void
  }
  class DriverDisplay {
    -driverName String
    +DriverDisplay(driverName)
    +update(data String) void
  }
  class EngineerDisplay {
    -engineerName String
    +EngineerDisplay(engineerName)
    +update(data String) void
  }
  class PitWallDisplay {
    -displayId String
    +PitWallDisplay(displayId)
    +update(data String) void
  }
  DriverDisplay ..|> TelemetryMonitor
  EngineerDisplay ..|> TelemetryMonitor
  PitWallDisplay ..|> TelemetryMonitor
  TelemetrySubject "1" *-- "*" TelemetryMonitor : observers

  %% ===== Strategy (Lap forecast) =====
  class TireType {
    <<enumeration>>
    SOFT
    MEDIUM
    HARD
  }
  class Strategy {
    <<interface>>
    +execute(tyre TireType) int
  }
  class AggressiveStrategy
  class AverageStrategy
  class DefensiveStrategy
  AggressiveStrategy ..|> Strategy
  AverageStrategy ..|> Strategy
  DefensiveStrategy ..|> Strategy
  Strategy ..> TireType : parameter

  class LapForecast {
    -strategy Strategy
    +LapForecast(strategy Strategy)
    +LapForecast(style String)
    +executeStrategy(tyre TireType, fuelLoad int) double
  }
  LapForecast --> Strategy : uses
  LapForecast ..> AggressiveStrategy : creates
  LapForecast ..> AverageStrategy : creates
  LapForecast ..> DefensiveStrategy : creates

  %% ===== Demo glue =====
  class RaceCarDemo {
    +main(args String[]) void
  }
  RaceCarDemo ..> TelemetrySubject : demo
  RaceCarDemo ..> TelemetryMonitor : demo
  RaceCarDemo ..> LapForecast : demo
  RaceCarDemo ..> TireType : demo
  RaceCarDemo ..> Assembly : demo
  RaceCarDemo ..> Component : demo
  RaceCarDemo ..> CarComponent : demo
```

Notes:
- Composite: Assembly aggregates multiple CarComponent elements (components can be other assemblies or leaf Components).
- Observer: TelemetrySubject keeps a list of TelemetryMonitor observers and notifies them whenever data changes.
- Strategy: LapForecast delegates lap prediction behavior to a Strategy implementation selected by constructor (Aggressive, Average, Defensive).