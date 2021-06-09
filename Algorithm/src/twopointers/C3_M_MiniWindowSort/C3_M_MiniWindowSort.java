package twopointers.C3_M_MiniWindowSort;

public class C3_M_MiniWindowSort {
  public static int miniWindow(int[] arr){
    int start = 0, end = arr.length - 1;

    //find the substring
    while(start < arr.length - 1 && arr[start] <= arr[start + 1]){
      start++;
    }
    if(start == arr.length - 1) return 0;
    while(end > 0 && arr[end] >= arr[end - 1]){
      end--;
    }
    if(end == 0) return arr.length;

    //find the max and min
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for(int i = start; i <= end; i++){
      min = Math.min(min, arr[i]);
      max = Math.max(max, arr[i]);
    }

    //include all number out of substring
    while(start > 0 && arr[start - 1] < min){
      start--;
    }
    while(end < arr.length -1 && arr[end + 1] < max){
      end++;
    }

    return end - start + 1;
  }

  public static void main(String[] args) {
    System.out.println(miniWindow(new int[]{1,2,5,3,7,10,9,12}));
  }
}
