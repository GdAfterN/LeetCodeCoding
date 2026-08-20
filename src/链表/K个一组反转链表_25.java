package 链表;
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
        static ListNode reverseKGroup(ListNode head, int k){
            ListNode dum=new ListNode(0,head);
            ListNode start=dum;
            ListNode end=dum;
            while(end!=null){
                for(int i=0;i<k;i++){
                    end=end.next;
                    if(end==null) break;
                }
                if(end==null) break;
                ListNode trueStart=start.next;
                ListNode next=end.next;
                end.next=null;
                start.next=reverse(trueStart);
                trueStart.next=next;
                start=trueStart;
                end=trueStart;
            }
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
            int[] testVals=new int[]{1,2,3,4,5};
            ListNode testNode= createLinkedList(testVals);
            printLinkedList(reverseKGroup(testNode,2));
        }
    }
}
