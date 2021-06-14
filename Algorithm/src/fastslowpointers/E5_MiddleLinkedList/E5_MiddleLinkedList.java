package fastslowpointers.E5_MiddleLinkedList;

class ListNode{
  int value = 0;
  ListNode next;
  ListNode(int value){
    this.value = value;
  }
}

public class E5_MiddleLinkedList {
  public static ListNode findMiddle(ListNode head){
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = head.next.next;

    System.out.println(findMiddle(head).value);
  }
}
