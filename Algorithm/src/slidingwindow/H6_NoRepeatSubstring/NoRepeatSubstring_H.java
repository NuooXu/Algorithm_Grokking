package slidingwindow.H6_NoRepeatSubstring;

import java.util.HashMap;
import java.util.Map;

// Problem Statement #
// Given a string, find the length of the longest substring which has no repeating characters.

// Example 1:

// Input: String="aabccbb"
// Output: 3
// Explanation: The longest substring without any repeating characters is "abc".
// Example 2:

// Input: String="abbbb"
// Output: 2
// Explanation: The longest substring without any repeating characters is "ab".
// Example 3:

// Input: String="abccde"
// Output: 3
// Explanation: Longest substrings without any repeating characters are "abc" & "cde".

public class NoRepeatSubstring_H {

  public static int findSbustring(String s){
    int start = 0, max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for(int end = 0; end < s.length(); end++){
      char rc = s.charAt(end);
      if(map.containsKey(rc)){
        start = Math.max(start, map.get(rc) + 1);
      }
      map.put(rc, end);
      max = Math.max(max, end - start + 1);
    }
    return max;
  }
  //33-35 tricky part: it not delete all the characters in map before the repeat one
  //it changed the index instead, also need to pay attention the start position
  //TIME: O(N) SPACE: O(1)

  public static void main(String[] args){
    int res1 = findSbustring("abccde");
    System.out.println(res1);
    int res2 = findSbustring("aabccbb");
    System.out.println(res2);
    System.out.println(findSbustring("abbbb"));
    System.out.println(findSbustring("aaaaaaa"));
    System.out.println(findSbustring("abccdea"));
  }
}


