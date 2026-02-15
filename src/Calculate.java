
public class Calculate {

    public static String calculate(String n1, String operator, String n2) {
        double result;
        double num1 = 0;
        double num2 = 0;

        if (n1.contains("^2") || n2.contains("^2")) {
            if (n1.contains("^2") && n2.contains("^2")) {
                num1 = square(n1);
                num2 = square(n2);
            } else if (n1.contains("^2")) {
                num1 = square(n1);
                num2 = Double.parseDouble(n2);
            } else if (n2.contains("^2")) {
                num2 = square(n2);
                num1 = Double.parseDouble(n1);
            }
        }

        else {
            num1 = Double.parseDouble(n1);
            num2 = Double.parseDouble(n2);
        }
        result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        if (CalcActionListener.isInteger(result)) {
            int intResult = (int) result;
            return Integer.toString(intResult);
        }

        return Double.toString(result);
    }

    public static double square(String num) {

        double square = 0;

        if (num.contains("^2")) {
            num = num.substring(0, num.indexOf("^"));
            square = Double.parseDouble(num);
            square *= square;
        }

        return square;
    }

}
