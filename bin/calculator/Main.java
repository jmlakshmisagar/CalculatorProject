import javax.swing.*;

public class Main extends CalculatorUI {

    public Main() {
        super("Calculator");
    }

    @Override
    public void calculateResult() {
        try {
            double result = 0;
            double number = Double.parseDouble(display.getText());

            switch (operator) {
                case "+":
                    result = currentNumber + number;
                    break;
                case "-":
                    result = currentNumber - number;
                    break;
                case "*":
                    result = currentNumber * number;
                    break;
                case "/":
                    if (number != 0) {
                        result = currentNumber / number;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
                case "%":
                    if (number != 0) {
                        result = currentNumber % number;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
                case "√":
                    result = Math.sqrt(number);
                    break;
            }

            if (result == (int) result) {
                display.setText(String.valueOf((int) result));
            } else {
                display.setText(String.format("%.2f", result));
            }
            operator = "";
            currentNumber = result;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    @Override
    public void clear() {
        display.setText("0");
        operator = "";
        currentNumber = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
