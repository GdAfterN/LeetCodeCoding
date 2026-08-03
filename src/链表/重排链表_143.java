package 链表;

public class 重排链表_143 {
    static class Solution{
        static class ListNode{
            int val;
            ListNode next;
            public ListNode(){};
            public ListNode(int val){this.val=val;};
            public ListNode(int val,ListNode next){
                this.val=val;
                this.next=next;
            }
        }
        static void printLinkedList(ListNode head){
            if(head==null){
                System.out.println("null");
                return;
            }
            ListNode p=head;
            while(p!=null){
                if(p.next==null) System.out.println(p.val);
                else System.out.print(p.val+"->");
                p=p.next;
            }
        }
        static ListNode toLinkedList(int[] vals){
            ListNode dum=new ListNode();
            ListNode p=dum;
            for(int val:vals){
                p.next=new ListNode(val);
                p=p.next;
            }
            return dum.next;
        }
        static void reorderList(ListNode head) {
            ListNode slow=head;
            ListNode fast=head.next;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode right=slow.next;
            slow.next=null;
            ListNode headB=reverse(right);
            merge(head,headB);
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
        static void merge(ListNode headA,ListNode headB){
            ListNode p1;
            ListNode p2;
            while(headA!=null&&headB!=null){
                p1=headA.next;
                p2=headB.next;
                headA.next=headB;
                headA=p1;
                headB.next=headA;
                headB=p2;
            }
        }
        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4,5};
            ListNode test1=toLinkedList(vals);
            reorderList(test1);
            printLinkedList(test1);
        }
    }
}
