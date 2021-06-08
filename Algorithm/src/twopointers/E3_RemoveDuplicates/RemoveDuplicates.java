package twopointers.E3_RemoveDuplicates;

// Problem Statement #
// Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

// Example 1:

// Input: [2, 3, 3, 3, 6, 9, 9]
// Output: 4
// Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
// Example 2:

// Input: [2, 2, 2, 11]
// Output: 2
// Explanation: The first two elements after removing the duplicates will be [2, 11].

// ---------------------------
// Similar Questions #
// Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

// Example 1:

// Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
// Output: 4
// Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
// Example 2:

// Input: [2, 11, 2, 2, 1], Key=2
// Output: 2
// Explanation: The first two elements after removing every 'Key' will be [11, 1].

public class RemoveDuplicates {

  public static int remove(int[] arr){
    int next = 1;
    for(int cur = 1; cur < arr.length; cur++){
      if(arr[next - 1] != arr[cur]){
        arr[next] = arr[cur];
        next++;
      }
    }
    return next;
  }

  public static int followUp(int[] arr, int key){
    int next = 0;
    for(int cur = 0; cur < arr.length; cur++){
      if(arr[cur] != key){
        arr[next] = arr[cur];
        next++;
      }
    }
    return next;
  }
    

  public static void main(String[] args){
    System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
    System.out.println(remove(new int[]{2, 2, 2, 11}));
    System.out.println(followUp(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3));
    System.out.println(followUp(new int[]{2, 11, 2, 2, 1}, 2));
  }
}

// 2, 3, 3, 3, 6, 9, 9