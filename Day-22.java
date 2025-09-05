import java.util.*;

public class FirstElementToRepeatKTimes {

    public static int firstElementKTimes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;   
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array elements : ");
        String[] parts = sc.nextLine().trim().split(" ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Enter an integer K : ");
        int k = sc.nextInt();

        int result = firstElementKTimes(arr, k);
        System.out.println("The first element in the array that appears exactly k times : "+result);

        sc.close();
    }
}
