package 链表;

public class 有序链表删除重复元素2_82 {
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
            ListNode dum=new ListNode(0,head);
            ListNode pre=dum;
            ListNode cur=head;
            while(cur!=null){
                if(cur!=null&&cur.next!=null&&cur.val==cur.next.val){
                    int duplicate=cur.val;
                    while(cur!=null&&cur.val==duplicate){
                        cur=cur.next;
                    }
                    pre.next=cur;
                }
                else{
                    pre=cur;
                    cur=cur.next;
                }

            }return dum.next;
        }
        public static void main(String[] args){
            int[] vals=new int[]{1,1,3,3,4,5,6,7,8,8,9,9,9,9,0};
            ListNode head=toLinkedList(vals);
            printLinkedList(deleteDuplicates(head));
        }
    }
}
