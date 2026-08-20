package 链表;

public class 回文链表_234 {
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

        static boolean isPalindrome(ListNode head){
           ListNode slow=head;
           ListNode fast=head.next;
           while(fast!=null&&fast.next!=null){
               slow=slow.next;
               fast=fast.next.next;
           }
           ListNode headB=slow.next;
           slow.next=null;
           ListNode revHeadB=reverse(headB);
           while(head!=null&&revHeadB!=null){
               if(head.val!=revHeadB.val) return false;
               head=head.next;
               revHeadB=revHeadB.next;
           }
           return true;
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
            int[] vals=new int[]{1,2,2,2};
            ListNode head=toLinkedList(vals);
            System.out.println(isPalindrome(head));
        }
    }
}
