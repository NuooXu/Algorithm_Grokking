package slidingwindow;

import java.util.HashMap;
import java.util.Map;

// Problem Statement #
// Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

// Example 1:

// Input: String="aabccbb", k=2
// Output: 5
// Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
// Example 2:

// Input: String="abbcb", k=1
// Output: 4
// Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
// Example 3:

// Input: String="abccde", k=1
// Output: 3
// Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

public class LongestSubstringSameLettersReplacement {
  public static int findLongestSubstring(String s, int k){
    //通过不断记录当前出现的字符的最高频次,while中用window的长度-最高频次，若<=k则继续添加
    //若>k，则要把start向前移一位，并在map中相应的-1
    int max = 0;
    int start = 0;
    Map<Character, Integer> map = new HashMap<>();
    int curMaxFre = 0;

    for(int end = 0; end < s.length(); end++){
      map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
      curMaxFre = Math.max(curMaxFre, map.get(s.charAt(end)));

      while((end - start + 1) - curMaxFre > k){
        map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
        start++;
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
  public static void main(String[] args){
    System.out.println(findLongestSubstring("abccde", 1));
    System.out.println(findLongestSubstring("abbcb", 1));
    System.out.println(findLongestSubstring("aabccbb", 2));
  }
}
// aabcdbb k=2
// abccde k=1
