package slidingwindow.M4LongestSubstringwithKDistinctChars;

import java.util.HashMap;
import java.util.Map;

// Problem Statement #
// Given a string, find the length of the longest substring in it with no more than K distinct characters.

// Example 1:

// Input: String="araaci", K=2
// Output: 4
// Explanation: The longest substring with no more than '2' distinct characters is "araa".
// Example 2:

// Input: String="araaci", K=1
// Output: 2
// Explanation: The longest substring with no more than '1' distinct characters is "aa".
// Example 3:

// Input: String="cbbebi", K=3
// Output: 5
// Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

public class LongestSubstringwithKDistinctChars {

  public static int findLongestSubstring(int K, String s){
    int start = 0, max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for(int end = 0; end < s.length(); end++){
      char rc = s.charAt(end);
      map.put(rc, map.getOrDefault(rc, 0) + 1);
      while(map.size() > K){
        char lc = s.charAt(start);
        map.put(lc, map.get(lc) - 1);
        if(map.get(lc) == 0){
          map.remove(lc);
        }
        start++;
      }
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
  //Time: O(n) space:O(k)

  public static void main(String[] args){
    int res1 = findLongestSubstring(3, "cbbebi");
    System.out.println(res1);

    int res2 = findLongestSubstring(1, "araaci");
    System.out.println(res2);
  }
}
