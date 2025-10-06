interface CalculatorStrategy {
    int execute(int num1, int num2);
}

static class OperationAdd implements CalculatorStrategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 + num2;
    }
}

static class OperationSubtract implements CalculatorStrategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 - num2;
    }
}

class Calculator {
    private final CalculatorStrategy strategy;

    public Calculator(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2) {
        return strategy.execute(num1, num2);
    }
}

void main() {
    Calculator add = new Calculator(new OperationAdd());
    System.out.printf("10 + 5 = %d%n", add.execute(10, 5));

    Calculator sub = new Calculator(new OperationSubtract());
    System.out.printf("10 - 5 = %d%n", sub.execute(10, 5));
}
