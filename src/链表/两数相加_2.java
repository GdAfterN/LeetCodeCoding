package 链表;

//给你两个非空链表，表示两个非负整数。数字以逆序存储，每个节点只存储一位数字。
//请将两数相加，并以相同形式返回一个表示和的链表。除数字 0 外，这两个数都不会以 0 开头。
public class 两数相加_2 {
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

        static ListNode plusTwo(ListNode headA,ListNode headB){
            ListNode dum=new ListNode();
            ListNode p=dum;
            ListNode p1=headA,p2=headB;
            int c=0;
            while(p1!=null||p2!=null){
                int val1=p1==null?0:p1.val;
                int val2=p2==null?0:p2.val;
                int sum=c+val1+val2;
                c=sum/10;
                p.next=new ListNode(sum%10);
                p=p.next;
                if(p1!=null) p1=p1.next;
                if(p2!=null) p2=p2.next;
            }
            if(c!=0) p.next=new ListNode(c);
            return dum.next;
        }

        public static void main(String[] args){
            int[] vals1=new int[]{9,4,2};
            int[] vals2=new int[]{7,4,3,9,1};
            ListNode headA=createLinkedList(vals1);
            ListNode headB=createLinkedList(vals2);
            printLinkedList(plusTwo(headA,headB));
        }
    }
}
