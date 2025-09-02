import java.util.*;

public class PostfixEvaluation {

    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+"); 

        for (String token : tokens) {
    
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();  
                int a = stack.pop();  

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
          
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression : ");
        String expression = sc.nextLine();

        int result = evaluatePostfix(expression);
        System.out.println("Result : "+result);
    }
}
