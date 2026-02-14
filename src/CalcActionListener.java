import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

public class CalcActionListener implements ActionListener {

    private final Calculator calc;
    private final JTextField result;
    private ArrayList<String> equation = new ArrayList<>();

    public CalcActionListener(Calculator calc, JTextField result, ArrayList<String> equation) {
        this.calc = calc;
        this.result = result;
        this.equation = equation;
    }

    public boolean isInteger(Double num) {
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
                equation.add(action);

            } else {

                result.setText(result.getText() + action);
                equation.add(action);
            }

        } else if ("DelClear".contains(action)) {

            if (action.equals("Clear")) {
                result.setText("0");
                equation.clear();

            } else if (action.equals("Del")) {
                if (!equation.isEmpty()) {
                    equation.removeLast();
                }
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
                        equation.add(action);

                    } else {
                        result.setText(Double.toString(num));
                        equation.add(action);
                    }
                }
            }

            else if (action.equals(".")) {

                if (!result.getText().contains(".")) {
                    result.setText(result.getText() + ".");
                    equation.add(action);
                }
            }

        } else if ("+-/*^2".contains(action)) {

            if ("+-/*".contains(action)) {

                if ("+-/*".contains("h")) {
                    equation.remove(equation.getLast());
                }
                result.setText(action);
                equation.add(action);

            } else {

                if (!result.getText().contains("^2")) {
                    if (!equation.getLast().equals(".")) {
                        result.setText(result.getText() + "^2");
                        equation.add(action);
                    }
                }
            }
        } else {
            if (equation == null) {
                result.setText("Empty");
            } else {
                result.setText(Calculate.calculate(equation));
            }
        }
    }
}