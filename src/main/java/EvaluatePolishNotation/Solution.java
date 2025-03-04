package EvaluatePolishNotation;

// https://neetcode.io/problems/evaluate-reverse-polish-notation

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stiva = new Stack<>();

        for (String operand : tokens) {
            if (!operand.matches("[-+*/]")) {
                stiva.push(operand);
            } else {
                Integer b = Integer.parseInt(stiva.pop());
                Integer a = Integer.parseInt(stiva.pop());

                Integer result = switch (operand) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new IllegalArgumentException("Invalid Operator: " + operand);
                };
                stiva.push(result.toString());
            }
        }

        return Integer.parseInt(stiva.pop());
    }
}
