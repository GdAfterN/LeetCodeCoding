package 链表;

//给你一个链表，请你两两交换其中相邻的节点，并返回交换后链表的头节点。
//必须在不修改节点内部值的情况下完成本题，只能进行节点交换。
public class 两两交换链表中的节点_24 {
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

        static ListNode swapNext(ListNode head){
            ListNode dum=new ListNode();
            dum.next=head;
            ListNode p=dum;
            // 至少后面还有俩个节点
            while(p.next!=null&&p.next.next!=null){
                ListNode a=p.next;
                ListNode b=p.next.next;
                ListNode next=b.next;
                p.next=b;
                b.next=a;
                a.next=next;
                p=a;
            }return dum.next;
        }

        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4,5,6,7};
            ListNode test=createLinkedList(vals);
            printLinkedList(swapNext(test));
        }
    }
}
