## Diagrama de UML para o Strategy Antipattern

```mermaid
classDiagram
    direction LR

    %% Enum Definition (often nested or closely associated with the class)
    class AntiPatternCalculator.Operation {
        <<enum>>
        ADD
        SUBTRACT
    }

    %% The God Object Class
    class AntiPatternCalculator {
        + execute(operation: Operation, num1: int, num2: int): int
    }

    %% Relationship (Implicit usage, not a formal UML association for this simple case)
    %% The AntiPatternCalculator implicitly "uses" or "depends on" its own Operation enum.
    %% We can show this as a dependency or simply implied by the method signature.
    AntiPatternCalculator ..> AntiPatternCalculator.Operation : uses
```
