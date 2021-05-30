import java.util.Stack;

public class ArithmeticEXpressionEval {

    public static Double eval(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Double> values = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                values.push(Double.parseDouble(Character.toString(ch)));
            } else if (ch == '(') continue;
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') operators.push(ch);
            else if (ch == ')') {
                Double val1 = values.pop();
                Double val2 = values.pop();
                Character op = operators.pop();
                if (op == '+') values.push(val2 + val1);
                else if (op == '-') values.push(val2 - val1);
                else if (op == '*') values.push(val2 * val1);
                else if (op == '/') values.push(val2 / val1);
            }
        }
        return values.pop();
    }

    public static void main(String[] args) {
        String s = "(1+((2+3)*(4*5)))";
        System.out.println(eval(s));
    }
}
