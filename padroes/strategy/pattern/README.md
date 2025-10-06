## Diagrama de UML para o Strategy 

```mermaid
classDiagram
    direction LR

    class CalculatorStrategy {
        <<interface>>
        + execute(num1, num2): int
    }

    class OperationAdd {
        + execute(num1, num2): int
    }
    class OperationSubtract {
        + execute(num1, num2): int
    }
    
    class Calculator {
        - CalculatorStrategy strategy
        + Calculator(strategy)
        + execute(num1, num2): int
    }
    
    OperationAdd ..|> CalculatorStrategy : implements
    OperationSubtract ..|> CalculatorStrategy : implements
    Calculator o-- CalculatorStrategy : has a
```

