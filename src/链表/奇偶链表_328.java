package 链表;

public class 奇偶链表_328 {
    static class Solution{
        static class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
static void printLinkedList(ListNode head){
    StringBuilder sb=new StringBuilder();
    ListNode cur=head;
    while(cur!=null){
        if(cur.next!=null) sb.append(cur.val+"->");
        else sb.append(cur.val);
        cur=cur.next;
    }System.out.println(sb.toString());
}
static ListNode toLinkedList(int[] vals){
    ListNode dummy=new ListNode();
    ListNode cur=dummy;
    for(int val:vals){
        cur.next=new ListNode(val);
        cur=cur.next;
    }
    return dummy.next;}

        // 使用偶数节点前判
        static ListNode ddEvenList(ListNode head){
          ListNode oddHead=head;
          ListNode evenHead=head.next;
          ListNode even=evenHead;
          ListNode odd=oddHead;
          while(even!=null&&even.next!=null){
              odd.next=even.next;;
              odd=odd.next;
              even.next=even.next.next;
              even=even.next;
          }
          odd.next=evenHead;
          return oddHead;
        }

        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4,5,6,7};
            ListNode node=toLinkedList(vals);
            printLinkedList(ddEvenList(node));
        }
    }
}
