package slidingwindow;

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
    int max = 0;
    int start = 0;
    Map<Character, Integer> map = new HashMap<>();

    for(int end = 0; end < arr.length; end++){
      map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

      while(map.size() > 2){
        int value = map.get(arr[start]);
        if(value == 1){
          map.remove(arr[start]);
        }else if(value > 1){
          map.put(arr[start], value - 1);
        }
        start++;
      }

      int len = end - start + 1;
      max = Math.max(max, len);      
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
