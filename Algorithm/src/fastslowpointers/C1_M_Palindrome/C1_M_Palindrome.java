package fastslowpointers.C1_M_Palindrome;

class ListNode{
  int value = 0;
  ListNode next;

  ListNode(int value){
    this.value = value;
  }
}

public class C1_M_Palindrome {
  public static boolean palindrome(ListNode head){
    ListNode slow = head, fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    
    ListNode halfhead = reverse(slow);
    // ListNode copyreversehead = halfhead;

    while(head != null && halfhead != null){
      if(head.value != halfhead.value){
        break;
      }
      head = head.next;
      halfhead = halfhead.next;
    }
    if(head == null || halfhead == null){
      return true;
    }
    return false;
  }

  public static ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(21);
    head.next.next.next.next = new ListNode(1);

    System.out.println(palindrome(head));
  }
}

