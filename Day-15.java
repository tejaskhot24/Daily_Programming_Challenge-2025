import java.util.*;

public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(lengthOfLongestSubstring("bbbbb"));  
        System.out.println(lengthOfLongestSubstring("pwwkew"));  
        System.out.println(lengthOfLongestSubstring("abcdefgh")); 
        System.out.println(lengthOfLongestSubstring("a"));        
    }
}
