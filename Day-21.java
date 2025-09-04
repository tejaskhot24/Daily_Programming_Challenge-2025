import java.util.*;

public class ReverseStack {

    public static void insertAtBottom(Stack<Integer> st, int element) {
        if (st.isEmpty()) {
            st.push(element);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, element);
        st.push(top);
    }

    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        reverseStack(st);          
        insertAtBottom(st, top);   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack of integers : ");
        String line = sc.nextLine().trim();
        Stack<Integer> st = new Stack<>();

        if (!line.isEmpty()) {
            String[] nums = line.split(" ");
            for (String num : nums) {
                st.push(Integer.parseInt(num));
            }
        }

        reverseStack(st);

        List<Integer> result = new ArrayList<>(st);
        System.out.print("\nThe reversed stack : ");
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}
