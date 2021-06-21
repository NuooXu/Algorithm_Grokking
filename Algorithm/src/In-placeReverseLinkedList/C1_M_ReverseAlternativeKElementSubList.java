package In-placeReverseLinkedList;

class ListNode{
  int value;
  ListNode next;
  ListNode(int value){
    this.value = value;
  }
}

public class C1_M_ReverseAlternativeKElementSubList {
  public static ListNode reverse(ListNode head, int p, int q){
    //coner case
    if(p == q) return head;

    //skip p-1 node
    ListNode prev = null;
    ListNode cur = head;
    for(int i = 0; cur != null && i < p - 1; i++){
      prev = cur;
      cur = cur.next;
    }

    //rever p->q nodes
    ListNode LastofFirst = prev;
    ListNode lasofSub = cur;
    ListNode next = null;

    for(int i = 0; cur != null && i < q - p + 1; i++){
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }

    //connect fisrt part
    if(LastofFirst != null){
      LastofFirst.next = prev;
    }else{
      LastofFirst.next = head;
    }

    //connect last part
    lasofSub.next = cur;

    return head;
  }
}
