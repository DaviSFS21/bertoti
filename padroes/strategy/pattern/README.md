## Diagrama de UML para o Strategy 

```mermaid
classDiagram
    direction LR

    %% Interface Definition
    interface CalculatorStrategy {
        <<interface>>
        + execute(num1, num2): int
    }
    
    %% Concrete Strategy Classes
    class OperationAdd {
        + execute(num1, num2): int
    }
    class OperationSubtract {
        + execute(num1, num2): int
    }
    
    %% Context Class
    class Calculator {
        - CalculatorStrategy strategy
        + Calculator(strategy)
        + execute(num1, num2): int
    }
    
    %% Relationships
    OperationAdd .up.|> CalculatorStrategy : implements
    OperationSubtract .up.|> CalculatorStrategy : implements
    Calculator o-- CalculatorStrategy : has a
```
