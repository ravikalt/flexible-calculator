package calculator;

public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

//    MODULUS; // Uncomment this new operation if required

    public double apply(double num1, double num2) {
        switch (this) {
            case ADD: return num1 + num2;
            case SUBTRACT: return num1 - num2;
            case MULTIPLY: return num1 * num2;
            case DIVIDE:
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return num1 / num2;
//            case MODULUS: return num1 % num2; // Uncomment this Implementation for MODULUS if required
            default:
                throw new UnsupportedOperationException("Operation not supported");
        }
    }
}
