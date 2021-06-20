package CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class E3_4_FindMissingNum {

  //3.FindMissingNumbers
  public static int find(int[] nums){
    int start = 0;
    while(start < nums.length){
      //注意条件nums[start] < nums.length很重要防止溢出
      if(nums[start] < nums.length && nums[start] != nums[nums[start]]){
        swap(nums, start, nums[start]);
      }else{
        start++;
      }
    }
    
    for(int i = 0; i < nums.length; i++){
      if(i != nums[i]) return i;
    }
    //如果前面都不是就只有最后一位缺少了
    return nums.length;
  }

  //4.FindAllMissingNumbers
  public static List<Integer> findAll(int[] nums){
    List<Integer> res = new ArrayList<>();
    int i = 0;
    while(i < nums.length){
      if(nums[i] != nums[nums[i] - 1]){
        swap(nums, i, nums[i] - 1);
      }else{
        i++;
      }
    }

    for(int j = 0; j < nums.length; j++){
      if(nums[j] != j + 1){
        res.add(j + 1);
      }
    }
    return res;
  }

  //5.Find Duplicate Number
  public static int findDuplicate(int[] nums){
    int i = 0;
    while(i < nums.length){
      if(nums[i] != i + 1){
        if(nums[i] != nums[nums[i] - 1]){
          swap(nums, i, nums[i] - 1);
        }else{
          return nums[i];
        }
      }else{
        i++;
      }
    }
    return -1;
  }

  //6.Find all duplicates
  public static List<Integer> findAllDuplicates(int[] nums){
    List<Integer> res = new ArrayList<>();
    int i = 0;
    while(i < nums.length){
      if(nums[i] != nums[nums[i] - 1]){
        swap(nums, i, nums[i] - 1);
      }else{
        i++;
      }
    }

    for(int j = 0; j < nums.length; j++){
      if(nums[j] != j + 1){
        res.add(nums[j]);
      }
    }

    return res;
  }

  public static void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(find(new int[] {4,0,3,1}));
    System.out.println(findAll(new int[] {2,3,1,8,2,3,5,1}));
    System.out.println(findDuplicate(new int[] {1,4,4,3,2}));
    System.out.println(findAllDuplicates(new int[] {3,4,4,5,5}));
  }
}
//3.FindMissingNumbers
// 0 1 2 3 4
// 4 0 3 1
// 0 4 3 1
// 0 4 1 3
// 0 1 4 3

//4.FindAllMissingNumbers
//0 1 2 3 4 5
//4 3 4 2 3 1
//3 3 4 2 4 1
//2 3 4 3 4 1
//4 3 2 3 4 1
//4 1 2 3 4 3
