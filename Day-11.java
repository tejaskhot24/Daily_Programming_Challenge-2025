import java.util.*;

public class UniquePermutations {

    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();

   
        Arrays.sort(chars);

   
        do {
            result.add(new String(chars)); 
        } while (nextPermutation(chars));  

        return result;
    }

  
    private static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;

       
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) return false; 

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int left = i + 1, right = arr.length - 1;
        while (left < right) {
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        List<String> permutations = permuteUnique(input);

        System.out.println("Unique Permutations:");
        for (String p : permutations) {
            System.out.print(p + " ");
        }
    }
}
