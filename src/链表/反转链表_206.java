package 链表;

public class 反转链表_206 {
static class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
static class Solution{
    static ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }return pre;
    }
    public static void main(String[] args){
        int[] test1=new int[]{1,2,3,4,5};
        ListNode head1=ToLinkedList(test1);
        PrintLinkedList(reverse(head1));
        int[] test2=new int[0];
        ListNode head2=ToLinkedList(test2);
        PrintLinkedList(reverse(head2));
    }
    static ListNode ToLinkedList(int[] vals){
        if(vals.length==0) return null;
        ListNode dum=new ListNode(0);
        ListNode cur=dum;
        for(int val:vals){
            cur.next=new ListNode(val);
            cur=cur.next;
        }
        return dum.next;
    }
    static void PrintLinkedList(ListNode head){
        StringBuilder sb=new StringBuilder();
        ListNode cur=head;
        while(cur!=null){
            sb.append(cur.val);
            if(cur.next!=null) sb.append("->");
            cur=cur.next;
        }
        System.out.println(sb.toString());
    }
}
}
