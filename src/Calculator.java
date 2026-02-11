import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

    public Calculator() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();

        JTextField result = new JTextField("0");

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JButton zero = new JButton();
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        JButton negative = new JButton("+/-");
        JButton decimal = new JButton(".");
        JButton percentage = new JButton("%");

        JButton clear = new JButton("C");
        JButton delete = new JButton("Del");

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton divide = new JButton("/");
        JButton multiply = new JButton("*");
        JButton equals = new JButton("=");

        gbc.ipady = 70;
        panel.add(result, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 0;

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(delete, gbc);

        gbc.gridx = 2;
        panel.add(clear, gbc);

        gbc.gridx = 3;
        panel.add(percentage, gbc);

        gbc.gridx = 4;
        panel.add(plus, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        panel.add(seven, gbc);

        gbc.gridx = 2;
        panel.add(eight, gbc);

        gbc.gridx = 3;
        panel.add(nine, gbc);

        gbc.gridx = 4;
        panel.add(minus, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        panel.add(four, gbc);

        gbc.gridx = 2;
        panel.add(five, gbc);

        gbc.gridx = 3;
        panel.add(six, gbc);

        gbc.gridx = 4;
        panel.add(multiply, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        panel.add(one, gbc);

        gbc.gridx = 2;
        panel.add(two, gbc);

        gbc.gridx = 3;
        panel.add(three, gbc);

        gbc.gridx = 4;
        panel.add(divide, gbc);

        gbc.gridy = 5;
        gbc.gridx = 1;
        panel.add(negative, gbc);

        gbc.gridx = 2;
        panel.add(zero, gbc);

        gbc.gridx = 3;
        panel.add(decimal, gbc);

        gbc.gridx = 4;
        panel.add(equals, gbc);

        frame.pack();
        frame.setVisible(true);

    }
}
