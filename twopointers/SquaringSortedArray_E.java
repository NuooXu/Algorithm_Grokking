package twopointers;

// Problem Statement #
// Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

// Example 1:

// Input: [-2, -1, 0, 2, 3]
// Output: [0, 1, 4, 4, 9]
// Example 2:

// Input: [-3, -1, 0, 1, 2]
// Output: [0 1 1 4 9]

public class SquaringSortedArray_E {
  //没想起来从两端比较大的放在最后啊
  //还有一些小细节要注意
  public static int[] squaring(int[] arr){
    int start = 0;
    int end = arr.length - 1;
    int[] res = new int[arr.length];

    int index = arr.length - 1;//最后一位是 长度-1
    while(start <= end){ //注意这里是 <= 
      int s1 = arr[start] * arr[start];
      int s2 = arr[end] * arr[end];
      if(s1 >= s2){
        res[index--] = s1;
        start++;
      }else{
        res[index--] = s2;
        end--;
      }
    }
    return res;
  }
  public static void main(String[] args) {
    int[] res = squaring(new int[]{-3, -1, 0, 1, 2});
    for (int i : res) {
      System.out.println(i);
    }
  }
}
