package SubSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E2_Subset {
  public static List<List<Integer>> subsets(int[] nums){
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for(int num : nums){
      int size = result.size();
      for(int i = 0; i < size; i++){
        List<Integer> set = new ArrayList<>(result.get(i));
        set.add(num);
        result.add(set);
      }
    }
    return result;
  }

  public static List<List<Integer>> subsetsWithDuplicates(int[] nums){
    List<List<Integer>> results = new ArrayList<>();
    int start = 0, end = 0;
    results.add(new ArrayList<>());
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++){
      start = 0;
      if(i > 0 && nums[i] == nums[i - 1]){
        start = end + 1;
      }
      end = results.size() - 1;
      for(int j = start; j <= end; j++){
        List<Integer> set = new ArrayList<>(results.get(j));
        set.add(nums[i]);
        results.add(set);
      }
    }
    return results;
  }

  public static List<List<Integer>> permutations(int[] nums){
    List<List<Integer>> results = new ArrayList<>();
    Queue<List<Integer>> permutation = new LinkedList<>();

    permutation.add(new ArrayList<>());
    for(int num : nums){
      int size = permutation.size();
      for(int i = 0; i < size; i++){
        List<Integer> old = permutation.poll();
        int oldSize = old.size();
        for(int j = 0; j < oldSize; j++){
          List<Integer> newOne = new ArrayList<>(old);
          newOne.add(j, num);
          if(newOne.size() == nums.length){
            results.add(newOne);
          }else{
            permutation.add(newOne);
          }
        }
      }
    }
    return results;
  }

  public static List<String> stringPermutation(String str){
    List<String> results = new ArrayList<>();
    if(str == null) return results;
    results.add(str);

    for(int i = 0; i < str.length(); i++){
      if(Character.isLetter(str.charAt(i))){
        int size = results.size();
        for(int j = 0; j < size; j++){
          char[] chars = results.get(j).toCharArray();
          if(Character.isUpperCase(chars[i])){
            chars[i] = Character.toLowerCase(chars[i]);
          }else{
            chars[i] = Character.toUpperCase(chars[i]);
          }
          results.add(String.valueOf(chars));
        }
      }
      
    }
    return results;
  }

}
