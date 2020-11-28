package slidingwindow.longestSubstringwithKDistinctCharacters_M;

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

    int max = 0;
    int start = 0;
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = s.toCharArray();

    for(int end = 0; end < chars.length; end++){
      map.put(chars[end],map.getOrDefault(chars[end], 0) + 1);

      while(map.size() > K){
        int len = end - start; //length should [start, end)
        max = Math.max(max, len);

        //remove the start character
        int value = map.get(chars[start]);
        if(value == 1){
          map.remove(chars[start]);
        }else if(value > 1){
          map.put(chars[start], value - 1);
        }
        start++;
      }
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
