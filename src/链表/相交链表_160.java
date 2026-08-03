package 链表;

public class 相交链表_160 {
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

        static ListNode getIntersectionNode(ListNode headA,ListNode headB){
            if(headA==null||headB==null) return null;
            ListNode p1=headA;
            ListNode p2=headB;
            while(p1!=p2){
                p1=p1==null?headB:p1.next;
                p2=p2==null?headA:p2.next;
            }
            return p1;
        }
    }
}
