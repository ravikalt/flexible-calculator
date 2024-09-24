package calculator;

public class Calculator {

    // Basic calculation method
    public double calculate(Operation op, Number num1, Number num2) {
        if (op == null) {
            throw new UnsupportedOperationException("Operation not supported");
        }
        return op.apply(num1.doubleValue(), num2.doubleValue());
    }


    // Chaining operations method
    public double chainCalculate(Number initialValue, Object... operationsAndNumbers) {

        if (!(initialValue instanceof Number)) {
            throw new IllegalArgumentException("Initial value must be a Number");
        }

        double result = initialValue.doubleValue();
        for (int i = 0; i < operationsAndNumbers.length; i += 2) {
            if (i + 1 >= operationsAndNumbers.length) {
                throw new IllegalArgumentException("Incomplete operation/number pair");
            }

            Object operationObj = operationsAndNumbers[i];
            Object numberObj = operationsAndNumbers[i + 1];

            //Validate operation type
            if (!(operationObj instanceof Operation)) {
                throw new IllegalArgumentException("Invalid operation type: " + operationObj);
            }

            //Validate number type
            if (!(numberObj instanceof Number)) {
                throw new IllegalArgumentException("Invalid number type: " + numberObj);
            }

            Operation operation = (Operation) operationObj;
            Number number = (Number) numberObj;
            result = operation.apply(result, number.doubleValue());
        }

        return result;
    }

}
