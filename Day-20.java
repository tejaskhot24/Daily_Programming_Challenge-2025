import java.util.*;

public class SortStackRecursion {

    public static void insertSorted(Stack<Integer> stack, int element) {
  
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int top = stack.pop();

        insertSorted(stack, element);

        stack.push(top);
    }

    public static void sortStack(Stack<Integer> stack) {
      
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        insertSorted(stack, top);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack of integers : ");
        String line = sc.nextLine().trim();
        Stack<Integer> stack = new Stack<>();

        if (!line.isEmpty()) {
            String[] nums = line.split("\\s+");
            for (String num : nums) {
                stack.push(Integer.parseInt(num));
            }
        }

        sortStack(stack);

        System.out.println("\nSorted stack in ascending order : "+stack);
    }
}
