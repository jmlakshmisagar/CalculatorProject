import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.CENTER);
    }

    protected JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1;
        gbc.weighty = 1;

        String[] buttonLabels = {
                "AC", "←", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "√", "0", ".", "="
        };

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            styleButton(buttons[i], buttonLabels[i]);
            buttons[i].addActionListener(this);
            gbc.gridx = i % 4;
            gbc.gridy = i / 4;
            buttonPanel.add(buttons[i], gbc);
        }
        return buttonPanel;
    }

    protected void styleButton(JButton button, String label) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        if ("+-*/%√=".contains(label)) {
            button.setBackground(new Color(128, 128, 128)); 
            button.setForeground(Color.WHITE);
        } else if ("AC".equals(label)) {
            button.setFont(new Font("Arial", Font.BOLD, 25));
            button.setBackground(Color.WHITE);
            button.setForeground(new Color(128, 128, 128));
        } else {
            button.setBackground(new Color(220, 220, 220));
            button.setForeground(Color.BLACK);
        }
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        handleButtonPress(command);
    }

    protected abstract void handleButtonPress(String command);
}
