package 链表;

public class 排序链表_148 {
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

        static ListNode sortList(ListNode head){
           if(head==null||head.next==null) return head;
           ListNode slow=head,fast=head.next;
           while(fast!=null&&fast.next!=null){
               slow=slow.next;
               fast=fast.next.next;
           }
           ListNode headB=slow.next;
           slow.next=null;
           return merge(sortList(head),sortList(headB));
        }
        static ListNode merge(ListNode headA,ListNode headB){
            ListNode dum=new ListNode();
            ListNode p=dum;
            ListNode p1=headA,p2=headB;
            while(p1!=null&&p2!=null){
                if(p1.val>=p2.val){
                    p.next=p2;
                    p2=p2.next;
                }
                else{
                    p.next=p1;
                    p1=p1.next;
                }
                p=p.next;
            }
            if(p1!=null) p.next=p1;
            else p.next=p2;
            return dum.next;
        }

        public static void main(String[] args){
            int[] vals=new int[]{2,3,5,6,7,3,2,};
            ListNode head=toLinkedList(vals);
            printLinkedList(sortList(head));
        }
    }
}
