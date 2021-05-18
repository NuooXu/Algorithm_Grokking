package fastslowpointers;

class ListNode{
  int value = 0;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}
public class LinkedListCycle_E {
  public static boolean hasCycle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null){ //注意循环的条件，没写对
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) return true; 
    }
    return false;
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    System.out.println(hasCycle(head));
  }
}
