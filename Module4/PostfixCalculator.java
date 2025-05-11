package Module4;

import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PostfixCalculator {
    // Evaluates a single postfix expression
    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
        
        try {
            // Split expression into tokens
            String[] tokens = postfixExpression.trim().split("\\s+");
            
            for (String token : tokens) {
                // Check if token is an operator
                if (token.equals("+") || token.equals("-") || 
                    token.equals("*") || token.equals("/") || token.equals("%")) {
                    // Need at least two operands for an operation
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Invalid postfix expression: insufficient operands");
                    }
                    
                    // Pop two operands (in reverse order since it's a stack)
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    
                    // Perform operation
                    switch (token) {
                        case "+":
                            stack.push(operand1 + operand2);
                            break;
                        case "-":
                            stack.push(operand1 - operand2);
                            break;
                        case "*":
                            stack.push(operand1 * operand2);
                            break;
                        case "/":
                            if (operand2 == 0) {
                                throw new IllegalArgumentException("Division by zero");
                            }
                            stack.push(operand1 / operand2);
                            break;
                        case "%":
                            if (operand2 == 0) {
                                throw new IllegalArgumentException("Modulus by zero");
                            }
                            stack.push(operand1 % operand2);
                            break;
                    }
                } else {
                    // Try to parse as number
                    try {
                        stack.push(Integer.parseInt(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid token: " + token);
                    }
                }
            }
            
            // Final result should be the only item on stack
            if (stack.size() != 1) {
                throw new IllegalArgumentException("Invalid postfix expression: too many operands");
            }
            
            return stack.pop();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    // Reads and evaluates expressions from a file
    public void evaluateFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            int expressionCount = 1;
            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine().trim();
                if (!expression.isEmpty()) {
                    System.out.println("Expression " + expressionCount + ": " + expression);
                    int result = evaluatePostfix(expression);
                    if (result != 0 || !expression.equals("Error")) {
                        System.out.println("Result " + expressionCount + ": " + result);
                    }
                    System.out.println();
                    expressionCount++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        }
    }

    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();

        // Test case 1: Valid single-digit expression
        System.out.println("Test Case 1: Single-digit operands");
        String expression1 = "4 2 * 3 +";
        System.out.println("Expression: " + expression1);
        System.out.println("Result: " + calculator.evaluatePostfix(expression1));
        System.out.println();

        // Test case 2: Valid multi-digit expression
        System.out.println("Test Case 2: Multi-digit operands");
        String expression2 = "53 7 + 8 *";
        System.out.println("Expression: " + expression2);
        System.out.println("Result: " + calculator.evaluatePostfix(expression2));
        System.out.println();

        // Test case 3: Invalid expression
        System.out.println("Test Case 3: Invalid expression");
        String expression3 = "4 2 * +";
        System.out.println("Expression: " + expression3);
        System.out.println("Result: " + calculator.evaluatePostfix(expression3));
        System.out.println();

        // Test case 4: File input
        System.out.println("Test Case 4: Reading from file");
        calculator.evaluateFromFile("expressions.txt");
    }
}