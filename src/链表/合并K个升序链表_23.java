package 链表;

//给你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，并返回合并后的链表。
public class 合并K个升序链表_23 {
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

        static ListNode mergeK(ListNode[] lists){
            if(lists.length==0) return null;
            while(lists.length>1){
                ListNode[] temp=new ListNode[(lists.length+1)/2];
                for(int i=0,j=0;i<lists.length;i+=2,j++){
                    ListNode l1=lists[i];
                    ListNode l2=i+1<lists.length?lists[i+1]:null;
                    temp[j]=merge(l1,l2);
                }
                lists=temp;
            }
            return lists[0];

        }
        static ListNode merge(ListNode headA,ListNode headB){
            ListNode dum=new ListNode();
            ListNode p=dum;
            ListNode p1=headA,p2=headB;
            while(p1!=null&&p2!=null){
                if(p1.val>=p2.val){
                    p.next=new ListNode(p2.val);
                    p2=p2.next;
                }else{
                    p.next=new ListNode(p1.val);
                    p1=p1.next;
                }p=p.next;
            }
            if(p1!=null) p.next=p1;
            else p.next=p2;
            return dum.next;
        }
    }
}
