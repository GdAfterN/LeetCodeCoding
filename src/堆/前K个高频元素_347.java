package 堆;

import java.util.*;

//给你一个整数数组 nums 和一个整数 k，请你返回其中出现频率前 k 高的元素。
//你可以按 任意顺序 返回答案。
public class 前K个高频元素_347 {
    static class Solution{
        static int[] topKFrequent(int[] nums,int k){
            Map<Integer,Integer> map=new HashMap<>();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                pq.offer(entry);
            }
            int[] res=new int[k];
            for(int i=0;i<k;i++){
                res[i]=pq.poll().getKey();
            }
            return res;
        }

        public static void main(String[] args){
            int[] nums=new int[]{1,1,1,2,2,3};
            System.out.println(Arrays.toString(topKFrequent(nums,2)));
        }
    }
}
