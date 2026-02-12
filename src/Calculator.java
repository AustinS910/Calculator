import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Calculator implements ActionListener {

    private final JFrame frame;
    private final JPanel panel;
    JTextField result;

    public Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();

        result = new JTextField("0");

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;

        gbc.ipady = 60;
        panel.add(result, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 0;

        String[] buttonLabels = { "Del", "Clear", "%", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3",
                "+/-", "0", ".", "=" };

        ArrayList<JButton> buttons = new ArrayList<>();

        for (String buttonLabel : buttonLabels) {
            JButton button = new JButton(buttonLabel);
            button.setActionCommand(buttonLabel);
            button.addActionListener(this);
            buttons.add(button);
        }

        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.gridwidth = 1;

        for (JButton button : buttons) {
            if (gbc.gridx == 4) {
                ++gbc.gridy;
                gbc.gridx = 1;
                panel.add(button, gbc);
            } else {
                panel.add(button, gbc);
                ++gbc.gridx;
            }
        }

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent button) {

    }

}
