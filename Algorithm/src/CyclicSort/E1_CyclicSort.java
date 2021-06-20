package CyclicSort;

public class E1_CyclicSort {
  public static void sort(int[] nums){
    int i = 0;
    while(i < nums.length){
      int j = nums[i] - 1;
      if(nums[i] != nums[j]){
        swap(nums, i, j);
      }else{
        i++;
      }
    }
  }

  public static void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  
}
