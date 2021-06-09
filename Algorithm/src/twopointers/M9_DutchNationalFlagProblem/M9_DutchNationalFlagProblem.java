package twopointers.M9_DutchNationalFlagProblem;

public class M9_DutchNationalFlagProblem {
  public static void flag(int[] arr){
    int start = 0, end = arr.length - 1;
    int cur = 0;
    while(cur <= end){
      if(arr[cur] == 0){
        swap(arr, cur, start);
        cur++;
        start++;
      }else if(cur == 1){
        cur++;
      }else if(cur == 2){
        swap(arr, cur, end);
        end--;//do not move cur
      }
    }
  }

  public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1,0,2,1,0};
    flag(arr);
    for(int num : arr){
      System.out.println(num);
    }
  }
}


