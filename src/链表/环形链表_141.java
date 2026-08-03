package 链表;

public class 环形链表_141 {
    static class Solution{
        static class ListNode{
            int val;
            ListNode next;
            ListNode(int val){
                this.val=val;
            }
            ListNode(int val, ListNode next){
                this.val=val;
                this.next=next;
            }
        }

        static ListNode toCycledLinkedList(int[] vals,int pos){
            ListNode dummy=new ListNode(0);
            ListNode cur=dummy;
            for(int val:vals){
                cur.next=new ListNode(val);
                cur=cur.next;
            }
            ListNode posn=dummy.next;
            for(int i=0;i<pos;i++){
                if(posn!=null) posn=posn.next;
            }
            if(pos>=0&&posn!=null){
            cur.next=posn;}
            return dummy.next;
        }
        static boolean hasCycle(ListNode head){
            ListNode slow=head;
            ListNode fast=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast) return true;
            }
            return false;
        }
        public static void main(String[] args){
            int[] vals=new int[]{1};
            ListNode head=toCycledLinkedList(vals,-1);
            System.out.println(hasCycle(head));
        }
    }
}
