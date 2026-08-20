package 链表;

//给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
//不允许修改链表。
public class 环形链表2_142 {
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

        static ListNode cycleList(ListNode head){
            ListNode slow=head;
            ListNode fast=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast) break;
            }
            if(slow!=fast) return null;
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }

        public static void main(String[] args){
            int[] vals=new int[]{1,2,3,4,5,6,7,8,};
            ListNode head=createLinkedList(vals);
            int pos=0;
            ListNode p=head,last=head;
            while(last.next!=null) last=last.next;
            for(int i=0;i<pos;i++) p=p.next;
            last.next=p;
            System.out.println(cycleList(head).val);
        }
    }
}
