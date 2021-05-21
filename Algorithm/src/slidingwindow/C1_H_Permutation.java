package slidingwindow;

import java.util.HashMap;
import java.util.Map;

class C1_H_Permutation {
  public static boolean findPermutation(String s, String p){
    int start = 0, matched = 0;

    //put characters in pattern in map
    Map<Character, Integer> map = new HashMap<>();
    for(char c : p.toCharArray()){
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    //sliding window
    for(int end = 0; end < s.length(); end++){

      char rc = s.charAt(end);
      if(map.containsKey(rc)){
        map.put(rc, map.get(rc) - 1);
        matched++;
      }

      //if all characters matched
      if(matched == p.length()){
        return true;
      }

      //keep sliding window p size
      if(end - start + 1 >= p.length()){
        char lc = s.charAt(start);
        if(map.containsKey(lc)){
          if(map.get(lc) == 0){
            matched--;
          }
          map.put(lc, map.getOrDefault(lc, 0) + 1);
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(findPermutation("oidbcaf", "abc"));
  }
}