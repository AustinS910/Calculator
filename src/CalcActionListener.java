import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class CalcActionListener implements ActionListener {

    private final Calculator calc;
    private final JTextField result;

    public CalcActionListener(Calculator calc, JTextField result) {
        this.calc = calc;
        this.result = result;

    }

    public static boolean isInteger(Double num) {
        return num % 1 == 0;
    }

    public String del(String str) {
        try {
            if (str.isEmpty() || str.equals("0")) {
                return "0";

            } else if (str.endsWith("^2")) {
                str = str.substring(0, str.length() - 2);
                return str;
            }

            else {
                str = str.substring(0, str.length() - 1);
                return str;
            }

        } catch (StringIndexOutOfBoundsException s) {
            return "0";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if ("0123456789".contains(action)) {

            if (result.getText().equals("0") || "+/-*".contains(result.getText())) {
                result.setText(action);

            } else {
                result.setText(result.getText() + action);

            }

        } else if ("DelClear".contains(action)) {

            if (action.equals("Clear")) {

                result.setText("0");

                Calculator.n1 = "0";
                Calculator.operator = null;
                Calculator.n2 = "0";

            } else if (action.equals("Del")) {

                result.setText(del(result.getText()));
            }

        } else if ("+/-".equals(action) || ".".equals(action)) {

            if (action.equals("+/-")) {

                if (!result.getText().equals("0")) {

                    double num = Double.parseDouble(result.getText());
                    num *= -1;

                    if (isInteger(num)) {
                        int num1 = (int) num;
                        result.setText(Integer.toString(num1));

                    } else {
                        result.setText(Double.toString(num));

                    }
                }
            }

            else if (action.equals(".")) {

                if (!result.getText().contains(".")) {
                    result.setText(result.getText() + ".");
                }
            }

        } else if ("+-/*^2".contains(action)) {

            if ("+-/*".contains(action)) {

                if (Calculator.operator == null) {
                    Calculator.n1 = result.getText();
                    result.setText("0");
                } else {
                    Calculator.n2 = result.getText();
                }
                Calculator.operator = action;

            } else {

                if (!result.getText().contains("^2")) {
                    if (!result.getText().endsWith("."))
                        result.setText(result.getText() + "^2");
                }
            }
        } else if (action.equals("=")) {
            try {

                if (Calculator.operator != null) {

                    Calculator.n2 = result.getText();

                    String answer = Calculate.calculate(Calculator.n1, Calculator.operator, Calculator.n2);
                    result.setText(answer);

                    Calculator.operator = null;
                    Calculator.n1 = "0";
                    Calculator.n2 = "0";

                } else if (Calculator.operator == null && result.getText().contains("^2")) {
                    String answer;
                    double num = Calculate.square(result.getText());

                    if (isInteger(num)) {
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