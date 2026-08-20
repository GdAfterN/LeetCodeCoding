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

        // 题眼在于不要用删除的方式去除节点，直接跳过即可
        static ListNode deleteDuplicates(ListNode head){
          ListNode dum=new ListNode();
          dum.next=head;
          ListNode p=dum;
          ListNode cur=head;
          while(cur!=null&&cur.next!=null){
              if(cur.val==cur.next.val){
                  int val=cur.val;
                  while(cur!=null&&cur.val==val) cur=cur.next;
                  p.next=cur;
              }else{
                  p=cur;
                  cur=cur.next;
              }
          }return dum.next;
        }
        public static void main(String[] args){
            int[] vals=new int[]{1,2,3};
            ListNode head=toLinkedList(vals);
            printLinkedList(deleteDuplicates(head));
        }
    }
}
