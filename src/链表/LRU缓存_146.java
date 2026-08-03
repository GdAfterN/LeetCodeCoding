package 链表;
import java.util.*;
//请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
//实现 LRUCache 类：
//LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
public class LRU缓存_146 {
    static class Solution{
        static class LRUCache{
            static class Node{
                int key,val;
                Node pre,next;
                public Node(){};
                public Node(int key,int val){
                    this.key=key;
                    this.val=val;
                }
            }
            static class DoubleList{
                Node first,end;
                public DoubleList(){
                    this.first=new Node();
                    this.end=new Node();
                    first.next=end;
                    end.pre=first;
                }
                public void addAtFirst(Node node){
                    Node next=first.next;
                    first.next=node;
                    node.pre=first;
                    node.next=next;
                    next.pre=node;
                }
                public void delete(Node node){
                    Node pre=node.pre;
                    Node next=node.next;
                    pre.next=next;
                    next.pre=pre;
                }
                public Node deleteAtLast(){
                    if(first.next==end) return null;
                    Node node=end.pre;
                    delete(node);
                    return node;
                }
            }
            Map<Integer,Node> map;
            int capacity;
            DoubleList list;
            public LRUCache(int capacity){
                this.capacity=capacity;
                this.map=new HashMap<>();
                this.list=new DoubleList();
            }
            public int get(int key){
                if(!map.containsKey(key)) return -1;
                Node node=map.get(key);
                list.delete(node);
                list.addAtFirst(node);
                return node.val;
            }
            public void put(int key, int value){
                if(map.containsKey(key)){
                    Node node=map.get(key);
                    list.delete(node);
                    node.val=value;
                    list.addAtFirst(node);
                }else{
                    if(map.size()==capacity){
                        Node node=list.deleteAtLast();
                        map.remove(node.key);
                        Node newNode=new Node(key,value);
                        map.put(key,newNode);
                        list.addAtFirst(newNode);
                    }else{
                        Node node=new Node(key,value);
                        map.put(key,node);
                        list.addAtFirst(node);
                    }
                }
            }
        }
        public static void main(String[] args){
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
            LRUCache lRUCache = new LRUCache(2);
            lRUCache.put(1, 1); // 缓存是 {1=1}
            lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
            System.out.println(lRUCache.get(1));    // 返回 1
            lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
            System.out.println(lRUCache.get(2));     // 返回 -1 (未找到)
            lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
            System.out.println(lRUCache.get(1));     // 返回 -1 (未找到)
            System.out.println(lRUCache.get(3));     // 返回 3
            System.out.println(lRUCache.get(4));     // 返回 4
        }
    }
}
