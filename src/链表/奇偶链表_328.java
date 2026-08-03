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

        static ListNode ddEvenList(ListNode head){
            if(head==null||head.next==null) return head;
            ListNode jHead=head;
            ListNode oHead=head.next;
            ListNode o=oHead;
            while(o!=null&&o.next!=null){
                ListNode j=o.next;
                o.next=o.next.next;
                jHead.next=j;
                jHead=jHead.next;
                o=o.next;
            }
            jHead.next=oHead;
            return head;
        }
    }
}
