//Calculate class, has calculate, square, isInteger, and del method

public class Calculate {
    /**
     * Calculates result of an equation
     * @param n1 String, representing a number
     * @param operator String representing a mathematical operation
     * @param n2 String representing a second number
     * @return String representing result
     */
    public static String calculate(String n1, String operator, String n2) {
        double result;
        double num1 = 0;
        double num2 = 0;

        //If n1 or n2 is a square number, calculate square first
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
        result = switch (operator) { //Switch case to calculate result
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        if (isInteger(result)) { //Check if result can be type-casted to int
            int intResult = (int) result;
            return Integer.toString(intResult);
        }

        return Double.toString(result);
    }

    /**
     * Calculates square of a number
     * @param num number to be squared
     * @return square of input
     */
    public static double square(String num) {

        double square = 0;

        if (num.contains("^2")) {
            num = num.substring(0, num.indexOf("^")); //Get substring up to "^2"
            square = Double.parseDouble(num);
            square *= square;
        }

        return square;
    }

    /**
     * Deletes last character of string
     * @param str String to modify
     * @return Modified string
     */
    public static String del(String str) {
        try {
            if (str.isEmpty() || str.equals("0")) {
                return "0";

                //Treat "^2" as one character
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

    /**
     * Checks if number is an integer
     * @param num Double to check
     * @return boolean representing if number is an integer
     */
    public static boolean isInteger(Double num) {
        return num % 1 == 0;
    }

}
