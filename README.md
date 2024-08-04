# Java Calculator

A simple yet modern calculator application built with Java Swing. This calculator performs basic arithmetic operations, including addition, subtraction, multiplication, and division, as well as some additional functions like percentage and square root. It features a clean and intuitive user interface with enhanced styling for buttons and display.

## Features

- **Basic Operations:** Addition, Subtraction, Multiplication, Division
- **Additional Functions:** Percentage, Square Root
- **Modern UI:** Stylish buttons and display with responsive layout
- **Error Handling:** Displays an error message for invalid operations (e.g., division by zero)


## Requirements

- Java Development Kit (JDK) 8 or higher
- An IDE or command-line tool to compile and run Java applications

## Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/jmlakshmisagar/calculator.git
    ```

2. **Navigate to the Project Directory:**

    ```bash
    cd calculator
    ```

3. **Compile the Java Files:**

    ```bash
    javac Main.java
    ```

4. **Run the Application:**

    ```bash
    java Main
    ```

## Usage

1. **Basic Operations:** Enter numbers and click on the operators (+, -, *, /) to perform basic arithmetic operations.
2. **Percentage:** Use the `%` button to calculate percentages.
3. **Square Root:** Use the `√` button to compute the square root of a number.
4. **Clear and Backspace:** Use `AC` to clear the display and `←` to remove the last digit.

## Code Overview

- **`CalculatorOperations` Interface:** Defines methods for calculator operations.
- **`AbstractCalculator` Class:** Provides the framework for the calculator UI and button handling.
- **`Main` Class:** Implements specific calculator functionality, including result calculation and error handling.

## Contributing

Contributions are welcome! Please fork the repository, make your changes, and submit a pull request.

