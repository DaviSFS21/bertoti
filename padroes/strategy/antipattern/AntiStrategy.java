class AntiPatternCalculator {
    public enum Operation {
        ADD,
        SUBTRACT
    }

    public int execute(Operation operation, int num1, int num2) {
        int result;

        if (operation == Operation.ADD) {
            result = num1 + num2;
        } else if (operation == Operation.SUBTRACT) {
            result = num1 - num2;
        } else {
            throw new IllegalArgumentException("Unsupported operation");
        }

        return result;
    }
}

void main() {
    AntiPatternCalculator calculator = new AntiPatternCalculator();
    System.out.printf("10 + 5 = %d%n", calculator.execute(AntiPatternCalculator.Operation.ADD, 10, 5));
    System.out.printf("10 - 5 = %d%n", calculator.execute(AntiPatternCalculator.Operation.SUBTRACT, 10, 5));
}