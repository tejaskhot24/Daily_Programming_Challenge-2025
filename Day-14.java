import java.util.*;

public class SubstringsWithKDistinct {

    private static int atMostKDistinct(String s, int k) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }

    public static int countSubstringsWithKDistinct(String s, int k) {
        if (k == 0) return 0;
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = countSubstringsWithKDistinct(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);

        sc.close();
    }
}
