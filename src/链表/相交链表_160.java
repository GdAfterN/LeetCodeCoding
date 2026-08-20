package 链表;

public class 相交链表_160 {
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

        static ListNode getIntersectionNode(ListNode headA,ListNode headB){
          ListNode p1=headA,p2=headB;
          while(p1!=p2){
              p1=p1==null?headB:p1.next;
              p2=p2==null?headA:p2.next;
          }
          return p1;
        }

        public static void main(String[] args){
            int[] common=new int[]{1,2,3,4,5};
            ListNode commonList=createLinkedList(common);
            int[] vals1=new int[]{5,7,9};
            int[] vals2=new int[]{8,6,2};
            ListNode headA=createLinkedList(vals1);
            ListNode tailA=headA;
            while(tailA.next!=null) tailA=tailA.next;
            tailA.next=commonList;
            ListNode headB=createLinkedList(vals2);
            ListNode tailB=headB;
            while(tailB.next!=null) tailB=tailB.next;
            tailB.next=commonList;
            ListNode res=getIntersectionNode(headA,headB);
            System.out.println(res!=null?res.val:"null");
        }
    }
}
