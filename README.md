# Flexible Calculator

This is a simple, extensible calculator implemented in Java. 
It supports basic arithmetic operations and  chaining of multiple operations. 

## Features

- It performs basic operations - ADD, SUBTRACT, MULTIPLY, DIVIDE
- It also performs Chaining Operations - Perform a sequence of operations on an initial value.

It also supports the following: 
- Extensibility: New operations can be added with minimal changes to existing code.
- Error Handling: Handles unsupported operations and division by zero.

Important points:
- To support the new operations, the MODULUS operation code has been commented out in the 'Operation' enum and the 'CalculatorJUnitTest' class. To enable this operation, uncomment the code without making changes to the 'Calculator' class.
- The 'CalculatorJUnitTest' class includes the unit test cases, and for simplicity and clarity, test data has been provided within this class.