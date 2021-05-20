package slidingwindow.M5_FruitsintoBaskets;

import java.util.HashMap;
import java.util.Map;

// Problem Statement #
// Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

// You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

// Write a function to return the maximum number of fruits in both the baskets.

// Example 1:

// Input: Fruit=['A', 'B', 'C', 'A', 'C']
// Output: 3
// Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
// Example 2:

// Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
// Output: 5
// Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
// This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

public class FruitsintoBaskets_M {

  public static int putFruits(char[] arr){
    int start = 0, max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for(int end = 0; end < arr.length; end++){
      char rc = arr[end];
      map.put(rc, map.getOrDefault(rc, 0) + 1);
      while(map.size() > 2){
        char lc = arr[start];
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

  public static void main(String[] args){
    int res1 = putFruits(new char[]{'A', 'B', 'C', 'A', 'C'});
    System.out.println(res1);

    int res2 = putFruits(new char[]{'A', 'B', 'C', 'B', 'B', 'C'});
    System.out.println(res2);
}
}
