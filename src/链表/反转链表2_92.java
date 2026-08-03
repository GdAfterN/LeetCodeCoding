package 链表;

public class 反转链表2_92 {
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

        static ListNode isPalindrome(ListNode head,int left,int right){
        if(head==null) return null;
        ListNode dum=new ListNode(0,head);
        ListNode slow=dum,fast=dum;
        for(int i=0;i<right-left;i++) fast=fast.next;
        for(int i=0;i<left-1;i++){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode start=slow.next;
        ListNode end=fast.next;
        ListNode next=end.next;
        end.next=null;
        ListNode rev=reverse(start);
        slow.next=rev;
        start.next=next;
        return dum.next;
        }
        static ListNode reverse(ListNode head){
            ListNode pre=null;
            ListNode cur=head;
            while(cur!=null){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            return pre;
        }
        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4,5};
            ListNode head=toLinkedList(vals);
            ListNode res=isPalindrome(head,2,5);
            printLinkedList(res);
        }
    }
}