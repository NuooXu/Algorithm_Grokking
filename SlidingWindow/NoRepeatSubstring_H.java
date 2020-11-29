package slidingwindow;

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
    int max = 0;
    int start = 0;
    char[] ch = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    
    for(int end = 0; end < ch.length; end++){
      
      if(map.containsKey(ch[end])){
        //* here need to compare with start, if not, abccdea, this situation will be wrong.
        //because a still in the map, it not be removed before
        start = Math.max(start, map.get(ch[end]) + 1);
      }
      //put new character and its index
      map.put(ch[end], end);
      //updata the max length
      max = Math.max(max, end - start + 1);
    }

    return max;
  }
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


