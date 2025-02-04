import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                " ", "0", " ", "="
        };

        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            buttonsPanel.add(button);
        }

        add(buttonsPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
