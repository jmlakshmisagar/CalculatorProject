package calculator;  // Use your package name if applicable

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Abstract class for a simple calculator
public abstract class AbstractCalculator extends JFrame implements ActionListener, CalculatorOperations {
    protected JTextField display;
    protected JButton[] buttons;
    protected String operator = "";
    protected double currentNumber = 0;

    public AbstractCalculator(String title) {
        setTitle(title);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display field with modern styling
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        add(display, BorderLayout.NORTH);

        // Create button panel with GridBagLayout for better control
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Button labels
        String[] buttonLabels = {
                "AC", "←", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "√", "0", ".", "="
        };

        // Initialize buttons with modern styling
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            if ("+-*/%√=".contains(buttonLabels[i])) {
                // Distinct styling for operator buttons
                buttons[i].setBackground(new Color(128, 128, 128)); // Gray color for operators
                buttons[i].setForeground(Color.WHITE);
            } else if ("AC".equals(buttonLabels[i])) {
                // Styling for the AC button
                buttons[i].setFont(new Font("Arial", Font.BOLD, 26));
                buttons[i].setBackground(new Color(255,255,255));
                buttons[i].setForeground(new Color(128, 128, 128));
            } else {
                // Default styling for other buttons
                buttons[i].setBackground(new Color(220, 220, 220));
                buttons[i].setForeground(Color.BLACK);
            }
            buttons[i].setFocusPainted(false);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            buttons[i].addActionListener(this);

            // Add buttons to the panel with GridBagConstraints
            gbc.gridx = i % 4;
            gbc.gridy = i / 4;
            buttonPanel.add(buttons[i], gbc);
        }

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

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
            if (display.getText().equals("0")){
                display.setText(command);
            }
            else{   
                display.setText(display.getText() + command);
            }
        }
    }

    // Method to handle backspace operation
    private void backspace() {
        String text = display.getText();
        if (text.length() > 0) {
            display.setText(text.substring(0, text.length() - 1));
            if (display.getText().isEmpty()) {
                display.setText("0");
            }
        }
    }
}
