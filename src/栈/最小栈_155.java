package 栈;
import java.util.*;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//实现 MinStack 类:
//
//MinStack() 初始化堆栈对象。
//void push(int value) 将元素 value 推入堆栈。
//void pop() 删除堆栈顶部的元素。
//int top() 获取堆栈顶部的元素。
//int getMin() 获取堆栈中的最小元素。

public class 最小栈_155 {
    static class Solution{
        static class MinStack{

            //需要实现获取栈顶部和获取栈中最小，所以需要俩个栈。一个普通栈一个最小栈

            //stack：保存完整数据
            //minStack：保存最小值的变化历史
            static Deque<Integer> stack;
            static Deque<Integer> minStack;

            public MinStack(){
                this.stack=new ArrayDeque<>();
                this.minStack=new ArrayDeque<>();
            }

            static void push(int value){
                stack.push(value);
                if(minStack.isEmpty()||value<=minStack.peek()) minStack.push(value);
            }

            static void pop(){
                int val=stack.pop();
                if(val==minStack.peek()) minStack.pop();
            }

            static int top(){
                return stack.peek();
            }

            static int getMin(){
                return minStack.peek();
            }

        }

        public static void main(String[] args){
            MinStack minStack=new MinStack();

            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);

            System.out.println(minStack.getMin()); // -3

            minStack.pop();

            System.out.println(minStack.top());    // 0
            System.out.println(minStack.getMin()); // -2
        }
    }

}
