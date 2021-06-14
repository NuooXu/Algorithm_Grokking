package fastslowpointers.C2_M_RerrangeLinkedList;

class ListNode{
  int value = 0;
  ListNode next;
  ListNode(int value){
    this.value = value;
  }
}

public class C2_M_RerrangeLinkedList {
  public static void rearrange(ListNode head){
    if(head == null || head.next == null){
      return;
    }
    //1.找到中点
    ListNode fast = head, slow = head;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    //2.反转后半段
    ListNode headSecondHalf = reverse(slow);;
    ListNode headFirstHalf = head;
    
    //3.交替指向
    while(headFirstHalf != null && headSecondHalf != null){
      ListNode temp = headFirstHalf.next;
      headFirstHalf.next = headSecondHalf;
      headFirstHalf = temp;

      temp = headSecondHalf.next;
      headSecondHalf.next = headFirstHalf;
      headSecondHalf = temp;
    }

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
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    rearrange(head);

    while(head != null){
      System.out.println(head.value + " ");
      head = head.next;
    }
  }
}
