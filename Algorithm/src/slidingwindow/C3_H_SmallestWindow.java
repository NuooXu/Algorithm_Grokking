package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class C3_H_SmallestWindow {
  public static String findSubstring(String s, String patten){
    int start = 0, minlen = s.length() + 1, match = 0;
    int minStart = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (char c : patten.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for(int end = 0; end < s.length(); end++){
      char rc = s.charAt(end);
      if(map.containsKey(rc)){
        map.put(rc, map.get(rc) - 1);
        if(map.get(rc) >= 0){
          match++;
        }
      }

      while(match == patten.length()){
        int len = end - start + 1;
        if(len < minlen){
          minlen = len;
          minStart = start;
        }
        char lc = s.charAt(start);
        start++;
        if(map.containsKey(lc)){
          if(map.get(lc) == 0){
            match--;
          }
          map.put(lc, map.get(lc) + 1);
        }

      }
    }
    return minlen > s.length() ? "" : s.substring(minStart, minStart + minlen);

  }
  

  public static void main(String[] args) {
    System.out.println(findSubstring("aabdec", "abc"));
  }
}
