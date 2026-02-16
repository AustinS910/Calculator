//Main Calculator class, creates Calculator GUI

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Calculator {

    private final JFrame frame;
    private final JPanel panel;
    private final JTextField result;

    //Variables to store numbers and operator in for ActionListener
    public static String n1 = "0";
    public static String operator = null;
    public static String n2 = "0";

    public Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout()); //Using GridBagLayout to create calculator GUI
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();

        result = new JTextField("0");

        //Changing textfield's looks
        result.setBackground(Color.gray);
        result.setForeground(Color.white);
        result.setFont(new Font("Arial", Font.BOLD, 50));
        result.setHorizontalAlignment(SwingConstants.RIGHT);

        //Changing panel's looks
        panel.setForeground(Color.white);
        panel.setBackground(Color.gray);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;

        //Adding textfield
        gbc.ipady = 70;
        panel.add(result, gbc);

        gbc.gridwidth = 1;
        gbc.ipady = 0;

        gbc.insets = new Insets(2, 2, 2, 2);

        //Array storing all of the button labels in a certain order for looping later on
        String[] buttonLabels = { "Del", "Clear", "^2", "+", "7", "8", "9", "-", "4", "5", "6", "*", "1", "2", "3", "/",
                "+/-", "0", ".", "=" };

        ArrayList<JButton> buttons = new ArrayList<>();

        //Iterating through buttonLabels array and creating a button from each label
        for (String buttonLabel : buttonLabels) {

            JButton button = new JButton(buttonLabel);

            button.setActionCommand(buttonLabel);
            button.addActionListener(new CalcActionListener(this, result)); //Setting buttons ActionListener
            buttons.add(button);
        }

        for (JButton button : buttons) {

            //Changing buttons looks
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

        //Looping through button ArrayList and adding buttons to panel
        //Manipulating gridx and gridy in for loop to add buttons in a 4 by 5 grid
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
