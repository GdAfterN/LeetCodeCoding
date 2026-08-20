package 链表;

public class 环形链表_141 {
    static class Solution{
        static class ListNode{
            int val;
            ListNode next;
            public ListNode(){};
            public ListNode(int val,ListNode next){
                this.val=val;
                this.next=next;
            }
            public ListNode(int val){
                this.val=val;
            }
        }

        static ListNode createLinkedList(int[] vals){
            if(vals.length==0) return null;
            ListNode dum=new ListNode();
            ListNode p=dum;
            for(int val:vals){
                p.next=new ListNode(val);
                p=p.next;
            }
            return dum.next;
        }
        static ListNode makeCycle(ListNode head,int pos){
            if(head==null||pos<0) return head;
            ListNode tail=head;
            while(tail.next!=null) tail=tail.next;
            ListNode entry=head;
            for(int i=0;i<pos;i++) entry=entry.next;
            tail.next=entry;
            return head;
        }
        static boolean hasCycle(ListNode head){
            ListNode slow=head,fast=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast) return true;
            }
            return false;
        }
        // 所有环都可以看作从尾部连接到某个位置（pos）
        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4};
            ListNode testHead=createLinkedList(vals);
            int pos=1;
            ListNode p=testHead,last=testHead;
            while(last.next!=null) last=last.next;
            for(int i=0;i<pos;i++) p=p.next;
            last.next=p;
            System.out.println(hasCycle(testHead));
        }
    }
}
