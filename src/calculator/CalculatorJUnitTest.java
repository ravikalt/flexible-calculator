package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorJUnitTest {

    Calculator calculator = new Calculator();

    /**
     * Testing the basic operations using parameterized tests.
     * For simplicity and clarity, data is taken as below
     */

    @ParameterizedTest
    @CsvSource({
            "ADD, 5, 3, 8",
            "SUBTRACT, 5, 3, 2",
            "MULTIPLY, 5, 3, 15",
            "DIVIDE, 6, 3, 2"
//            "MODULUS, 10, 3, 1" //Uncomment this for Modules operation
    })

//Handling the operation like ADD, SUBTRACT, MULTIPLY, DIVIDE
    public void testOperations(Operation op, double num1, double num2, double expected) {
        double result = calculator.calculate(op, num1, num2);
        assertEquals(expected, result, 0.001);
    }

//Test division by 0, Throws an exception
    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 10, 0);
        });
    }


    @Test
    public void testUnsupportedOperation() {
        // Test with a null operation
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(null, 10, 5);
        }, "Operation not supported: null");

        assertThrows(IllegalArgumentException.class, () -> {
            // Pass an invalid type for operation (e.g., a string)
            calculator.chainCalculate(5, "INVALID", 3);
        }, "Operation Type not supported.");
    }


//Handling chaining operations
    @Test
    public void testChainedOperations() {
        double result = calculator.chainCalculate(5,
                Operation.ADD, 3,
                Operation.MULTIPLY, 2
        );
        assertEquals(16.0, result, 0.001); // (5 + 3) * 2 = 16
    }

// Uncomment below code to test the MODULES operation. Make sure that MODULUS operation code in enum 'Operation' is uncommented
//    @Test
//    public void testChainedOperationsWithModulus() {
//        double result = calculator.chainCalculate(20,
//                Operation.SUBTRACT, 5,
//                Operation.MODULUS, 6
//        );
//        assertEquals(3.0, result, 0.001); // (20 - 5) % 6 = 1
//    }
}
