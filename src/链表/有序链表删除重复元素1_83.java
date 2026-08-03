package 链表;

public class 有序链表删除重复元素1_83 {
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

        static ListNode deleteDuplicates(ListNode head){
            ListNode p=head;
            while(p!=null&&p.next!=null){
                if(p.next.val==p.val) p.next=p.next.next;
                else p=p.next;
            }
            return head;
        }

        public static void main(String[] args){
            int[] vals=new int[]{1,1,3,3,3,6,7,8,8,9};
            ListNode head=toLinkedList(vals);
            ListNode head1=deleteDuplicates(head);
            printLinkedList(head1);
        }
    }
}
