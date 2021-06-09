package twopointers.C1_M_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class C1_M_4Sum {
  public static List<List<Integer>> quadruplets(int[] arr, int target){
    Arrays.sort(arr);
    List<List<Integer>> res = new ArrayList<>();
    for(int i = 0; i < arr.length - 3; i++){
      if(i > 0 && arr[i] == arr[i - 1])
        continue;
      for(int j = i + 1; j < arr.length - 2; j++){
        if(j > i + 1 && arr[j] == arr[j - 1])
          continue;
        pair(arr, target, i, j, res);
      }
    }
    return res;
  }

  public static void pair(int[] arr, int target, int first, int second, List<List<Integer>> res){
    int left = second + 1;
    int right = arr.length - 1;
    while(left < right){
      int sum = arr[first] + arr[second] + arr[left] + arr[right];
      if(sum == target){
        res.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
        left++;
        right--;
        while(left < right && arr[left] == arr[left - 1]) left++;
        while(left < right && arr[right] == arr[right + 1]) right--;
      }else if(sum > target){
        right--;
      }else{
        left++;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(quadruplets(new int[] {4,1,2,-1,1,-3}, 1));
  }
}
