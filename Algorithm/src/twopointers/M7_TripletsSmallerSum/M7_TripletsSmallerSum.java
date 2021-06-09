package twopointers.M7_TripletsSmallerSum;

import java.util.Arrays;

public class M7_TripletsSmallerSum {
  public static int triplets(int[] arr, int target){
    Arrays.sort(arr);
    int count = 0;
    for(int i = 0; i < arr.length - 2; i++){
      count += pair(arr, target - arr[i], i + 1);
    }
    return count;
  }

  public static int pair(int[] arr, int target, int left){
    int count = 0;
    int right = arr.length - 1;
    while(left < right){
      int sum = arr[left] + arr[right];
      if(sum < target){
        //because if it works with right, it works with all the number between left and right
        count += right - left;
        left++;
      }else{
        right--;//find a smaller sum
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(triplets(new int[]{-1, 0, 2, 3}, 3));
  }
}
