import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Calculator {

    private final JFrame frame;
    private final JPanel panel;
    private final JTextField result;

    public static String n1 = "0";
    public static String operator = null;
    public static String n2 = "0";

    public Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        panel.setForeground(Color.GRAY);
        panel.setBackground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();

        result = new JTextField("0");

        result.setBackground(Color.gray);
        result.setForeground(Color.white);
        result.setFont(new Font("Arial", Font.BOLD, 50));
        result.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.setForeground(Color.white);
        panel.setBackground(Color.gray);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;

        gbc.ipady = 70;
        panel.add(result, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 0;

        gbc.insets = new Insets(2, 2, 2, 2);

        String[] buttonLabels = { "Del", "Clear", "^2", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/",
                "+/-", "0", ".", "=" };

        ArrayList<JButton> buttons = new ArrayList<>();

        for (String buttonLabel : buttonLabels) {

            JButton button = new JButton(buttonLabel);

            button.setActionCommand(buttonLabel);
            button.addActionListener(new CalcActionListener(this, result));
            buttons.add(button);
        }

        for (JButton button : buttons) {

            button.setBorderPainted(false);
            button.setOpaque(true);
            button.setForeground(Color.white);

            button.setFont(new Font("Arial", Font.BOLD, 20));

            if (button.getActionCommand().equals("=")) {
                button.setBackground(new Color(34, 139, 34));

            } else if ("0123456789".contains(button.getActionCommand())) {
                button.setBackground(new Color(255, 109, 16));

            } else {
                button.setBackground(Color.darkGray);
            }
        }
        gbc.gridx = 1;
        gbc.gridy = 1;

        for (JButton button : buttons) {
            if (gbc.gridx > 4) {
                gbc.gridx = 1;
                ++gbc.gridy;
                panel.add(button, gbc);
                ++gbc.gridx;
            } else {
                panel.add(button, gbc);
                ++gbc.gridx;
            }
        }

        frame.pack();
        frame.setVisible(true);
    }

}
