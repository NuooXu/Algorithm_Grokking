package fastslowpointers.M3_StartLinkedListCycle;

class ListNode{
  int value = 0;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}

public class M3_StartLinkedListCycle {
  public static ListNode StartCycle(ListNode head){
    ListNode slow = head, fast = head;
    int len = 0;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){
        len = findLength(slow);
        break;
      }
    }
    return findStart(head, len);
  }

  public static int findLength(ListNode slow){
    ListNode cur = slow;
    int len = 0;
    do {
      cur = cur.next;
      len++;
    }while(cur != slow);
    return len;
  }

  public static ListNode findStart(ListNode head, int len){
    ListNode pointer1 = head, pointer2 = head;
    while(len > 0){
      pointer2 = pointer2.next;
      len--;
    }

    while(pointer1 != pointer2){
      pointer1 = pointer1.next;
      pointer2 = pointer2.next;
    }

    return pointer1;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = head.next.next;

    System.out.println(StartCycle(head).value);
  }
}
