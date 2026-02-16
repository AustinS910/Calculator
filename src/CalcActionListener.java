//ActionListener class for Calculator, has actionPerformed method for JButtons and all the necessary logic

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class CalcActionListener implements ActionListener {

    private final Calculator calc;
    private final JTextField result; //Textfield where input and answer is displayed

    public CalcActionListener(Calculator calc, JTextField result) {
        this.calc = calc;
        this.result = result;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if ("0123456789".contains(action)) {

            //If textfield is empty, set textfield to action
            if (result.getText().equals("0") || "+/-*".contains(result.getText())) {
                result.setText(action);

            } else {
                result.setText(result.getText() + action); //Append action to textfield

            }

        } else if ("DelClear".contains(action)) {

            if (action.equals("Clear")) {

                //Clear textfield and variables
                result.setText("0");
                Calculator.n1 = "0";
                Calculator.operator = null;
                Calculator.n2 = "0";

            } else if (action.equals("Del")) {

                result.setText(Calculate.del(result.getText())); //Call del function and textfield
            }

        } else if ("+/-".equals(action) || ".".equals(action)) {

            if (action.equals("+/-")) {

                if (!result.getText().equals("0")) {

                    //Multiply number by -1 to flip sign
                    double num = Double.parseDouble(result.getText());
                    num *= -1;

                    if (Calculate.isInteger(num)) { //Call isInteger method to check if num can be type-casted to int
                        int num1 = (int) num;
                        result.setText(Integer.toString(num1));

                    } else {
                        result.setText(Double.toString(num));

                    }
                }
            }

            else if (action.equals(".")) {

                if (!result.getText().contains(".")) { //Check if textfield already has a decimal point
                    result.setText(result.getText() + ".");
                }
            }

        } else if ("+-/*^2".contains(action)) {

            if ("+-/*".contains(action)) {

                if (Calculator.operator == null) { //If operator is num, store string from textfield in n1
                    Calculator.n1 = result.getText();
                    result.setText("0");
                } else {
                    Calculator.n2 = result.getText();
                }
                Calculator.operator = action;

            } else {

                if (!result.getText().contains("^2")) { //Check if textfield already has a square
                    if (!result.getText().endsWith("."))
                        result.setText(result.getText() + "^2");
                }
            }
        } else if (action.equals("=")) {
            try {

                if (Calculator.operator != null) {

                    Calculator.n2 = result.getText(); //Store string from textfield in n2

                    //Call calculate method and display result, reset variables
                    String answer = Calculate.calculate(Calculator.n1, Calculator.operator, Calculator.n2);
                    result.setText(answer);

                    Calculator.operator = null;
                    Calculator.n1 = "0";
                    Calculator.n2 = "0";

                    //If input is just a square, like "8^2" calculate the square and display result
                } else if (Calculator.operator == null && result.getText().contains("^2")) {
                    String answer;
                    double num = Calculate.square(result.getText());

                    if (Calculate.isInteger(num)) { //Check if number can be type-casted to int
                        int num1 = (int) num;
                        answer = Integer.toString(num1);

                    } else {
                        answer = Double.toString(num);
                    }
                    result.setText(answer);
                }

            } catch (NumberFormatException n) {
                result.setText("NFE");
            }

        } else {
            result.setText("0");
        }
    }
}