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

    public boolean isInteger(Double num) {
        return num % 1 == 0;
    }

    public String delete(String str) {
        if (str == null) {
            return "";
        } else {
            return str.substring(0, str.length() - 1);
        }
    }

    String equation = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if ("0123456789".contains(action)) {

            if (result.getText().equals("0") || "+/-*".contains(result.getText())) {
                result.setText(action);
                equation += action;

            } else {
                result.setText(result.getText() + action);
                equation += action;
            }
        } else if ("delClear".contains(action)) {

            if (action.equals("Clear")) {
                result.setText("0");
                equation = "";

            } else if (action.equals("del")) {
                result.setText(delete(result.getText()));
                equation = delete(equation);
            }

        } else if ("+/-".equals(action) || ".".equals(action)) {

            if (action.equals("+/-")) {

                if (!result.getText().equals("0")) {
                    double num = Double.parseDouble(result.getText());
                    num *= -1;

                    if (isInteger(num)) {
                        int num1 = (int) num;
                        result.setText(Integer.toString(num1));
                        equation += Integer.toString(num1);

                    } else {
                        result.setText(Double.toString(num));
                        equation += Double.toString(num);
                    }
                }
            } else if (action.equals(".")) {

                if (!result.getText().contains(".")) {
                    result.setText(result.getText() + ".");
                    equation += action;
                }
            }
        } else if ("+-/*^2".contains(action)) {

            if ("+-/*".contains(action)) {
                result.setText(action);
                equation += action;
                result.setHorizontalAlignment(JTextField.RIGHT);

            } else {

                if (!result.getText().contains("^2")) {
                    result.setText(result.getText() + "^2");
                    equation += action;
                }
            }
        }
    }
}
