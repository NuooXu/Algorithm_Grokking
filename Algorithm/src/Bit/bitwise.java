package Bit;

public class bitwise {
  public static int findNum(int[] arr){
    int num = 0;
    for(int i = 0; i < arr.length; i++){
      num = num ^ arr[i];
    }
    return num;
  }
}
