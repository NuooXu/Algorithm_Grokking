package fastslowpointers.M4_HappyNumber;

public class M4_HappyNumber {
  public static boolean findNumber(int num){
    int slow = num, fast = num;
    do{
      slow = square(num);
      fast = square(square(num));
    }while(slow != fast);

    return slow == 1;
  }

  public static int square(int num){
    int digit, sum = 0;
    while(num > 0){
      digit = num % 10;
      sum += digit * digit;
      num /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(findNumber(23));
  }
}
