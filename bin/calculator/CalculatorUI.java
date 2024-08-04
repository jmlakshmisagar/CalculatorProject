import javax.swing.*;

public class CalculatorUI extends AbstractCalculator {

    public CalculatorUI(String title) {
        super(title);
    }

    @Override
    protected void handleButtonPress(String command) {
        if (command.equals("=")) {
            calculateResult();
        } else if (command.equals("AC")) {
            clear();
        } else if (command.equals("←")) {
            backspace();
        } else if ("+-*/%√".contains(command)) {
            if (!display.getText().isEmpty()) {
                operator = command;
                currentNumber = Double.parseDouble(display.getText());
                display.setText("");
            }
        } else if (command.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        } else {
            if (display.getText().equals("0")) {
                display.setText(command);
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    private void backspace() {
        String text = display.getText();
        if (text.length() > 0) {
            display.setText(text.substring(0, text.length() - 1));
            if (display.getText().isEmpty()) {
                display.setText("0");
            }
        }
    }

    @Override
    public void calculateResult() {
        // Implement this in Main or BasicCalculator
    }

    @Override
    public void clear() {
        // Implement this in Main or BasicCalculator
    }
}
