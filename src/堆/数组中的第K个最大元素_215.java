package 堆;
import java.util.*;
public class 数组中的第K个最大元素_215 {
    static class Solution{
        static int  findKthLargest(int[] nums,int k){
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int num:nums){
                if(pq.size()<k) pq.offer(num);
                else if(num>pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }return pq.peek();
        }
        public static void main(String[] args){
            int[] test1=new int[]{3,2,1,5,6,4};
            System.out.println(findKthLargest(test1,2));
        }
    }
}
