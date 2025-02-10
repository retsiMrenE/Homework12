import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField textField;
    private int firstNumber = 0;
    private int secondNumber = 0;
    private String operator = "";
    private boolean isNewInput = true;

    public Calculator() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        textField = new JTextField("0");
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 32));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "", "0", "", "="
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            buttonsPanel.add(button);
        }

        add(buttonsPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("[0-9]")) {
                if (isNewInput) {
                    textField.setText(command);
                } else {
                    textField.setText(textField.getText() + command);
                }
                isNewInput = false;
            } else if (command.matches("[×\\-+]")) {
                firstNumber = Integer.parseInt(textField.getText());
                operator = command;
                isNewInput = true;
            } else if (command.equals("=")) {
                secondNumber = Integer.parseInt(textField.getText());
                int result = calculate(firstNumber, secondNumber, operator);
                textField.setText(String.valueOf(result));
                isNewInput = true;
            }
        }
    }

    private int calculate(int num1, int num2, String op) {
        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "×" -> num1 * num2;
            default -> num2;
        };
    }
}
