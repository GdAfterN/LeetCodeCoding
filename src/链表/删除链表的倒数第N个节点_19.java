package 链表;
//TODO 注意删除头节点情况
public class 删除链表的倒数第N个节点_19 {
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

        static ListNode removeNthFromEnd(ListNode head,int k){
            ListNode dummy=new ListNode(0,head);
            ListNode slow=dummy,fast=dummy;
            for(int i=0;i<k;i++){
                fast=fast.next;
            }
            while(fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            slow.next=slow.next.next;
            return dummy.next;
        }
        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4,5};
            ListNode head=toLinkedList(vals);
            ListNode head1=removeNthFromEnd(head,2);
            printLinkedList(head1);
        }
    }
}
