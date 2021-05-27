package slidingwindow.C2_H_StringAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class C2_H_StringAnagrams {
  public static List<Integer> findAnagrams(String s, String pattern) {
    int start = 0, match = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (char c : pattern.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    
    List<Integer> result = new ArrayList<>();
    for(int end = 0; end < s.length(); end++){
      char rc = s.charAt(end);
      if(map.containsKey(rc)){
        map.put(rc, map.get(rc) - 1);
        if(map.get(rc) == 0){
          match++;
        }
      }

      if(match == map.size()){
        result.add(start);
      }

      if(end >= pattern.length() - 1){
        char lc = s.charAt(start);
        if(map.containsKey(lc)){
          if(map.get(lc) == 0){
            match--;
          }
          map.put(lc, map.get(lc) + 1);
        }
        start++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(findAnagrams("ppqp", "pq"));
    System.out.println(findAnagrams("abbcabc", "abc"));
  }
}