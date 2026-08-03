package 链表;
//static class ListNode{
//    int val;
//    ListNode next;
//    ListNode(){};
//    ListNode(int val){
//        this.val=val;
//    }
//    ListNode(int val,ListNode next){
//        this.val=val;
//        this.next=next;
//    }
//}
//static void printLinkedList(ListNode head){
//    StringBuilder sb=new StringBuilder();
//    ListNode cur=head;
//    while(cur!=null){
//        if(cur.next!=null) sb.append(cur.val+"->");
//        else sb.append(cur.val);
//        cur=cur.next;
//    }System.out.println(sb.toString());
//}
//static ListNode toLinkedList(int[] vals){
//    ListNode dummy=new ListNode();
//    ListNode cur=dummy;
//    for(int val:vals){
//        cur.next=new ListNode(val);
//        cur=cur.next;
//    }
//    return dummy.next;}

public class K个一组反转链表_25 {
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
        static ListNode toLinkedList(int[] vals){
            if(vals.length==0) return null;
            ListNode dum=new ListNode();
            ListNode cur=dum;
            for(int val:vals){
                cur.next=new ListNode(val);
                cur=cur.next;
            }
            return dum.next;
        }
        static void printLinkedList(ListNode head){
            if(head==null) System.out.println("null");
            StringBuilder sb=new StringBuilder();
            ListNode cur=head;
            while(cur!=null){
                if(cur.next!=null) sb.append(cur.val+"->");
                else sb.append(cur.val);
                cur=cur.next;
            }System.out.println(sb.toString());
        }
        static ListNode reverseKGroup(ListNode head, int k){
            ListNode dummy=new ListNode();
            dummy.next=head;
            ListNode start=dummy;
            ListNode end=head;
            while(end!=null){
                for(int i=1;i<k;i++){
                    end=end.next;
                    if(end==null) break;
                }
                if(end==null) break;
                ListNode trueStart=start.next;
                ListNode next=end.next;
                end.next=null;
                start.next=reverse(trueStart);
                trueStart.next=next;
                end=next;
                start=trueStart;
            }
            return dummy.next;
        }
        static ListNode reverse(ListNode head){
            if(head==null) return null;
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
            int[] testVals=new int[]{1,2,3,4,5};
            ListNode testNode=toLinkedList(testVals);
            printLinkedList(reverseKGroup(testNode,3));
        }
    }
}
