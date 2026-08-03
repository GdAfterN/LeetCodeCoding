package 栈;
import java.util.*;
//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
//实现 MyQueue 类：
//
//void push(int x) 将元素 x 推到队列的末尾
//int pop() 从队列的开头移除并返回元素
//int peek() 返回队列开头的元素
//boolean empty() 如果队列为空，返回 true ；否则，返回 false
//说明：
//
//你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
//你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
public class 用栈实现队列_232 {
    static class Solution{
        static class MyDeque{
            static Deque<Integer> inStack;
            static Deque<Integer> outStack;

            public MyDeque(){
                this.inStack=new ArrayDeque<>();
                this.outStack=new ArrayDeque<>();
            }

            static void push(int x){
                inStack.push(x);
            }

            static int pop(){
                move(inStack,outStack);
                return outStack.pop();
            }

            static int peek(){
                move(inStack,outStack);
                return outStack.peek();
            }

            static boolean empty(){
                return inStack.isEmpty()&&outStack.isEmpty();
            }

            static void move(Deque<Integer> inStack,Deque<Integer> outStack){
                if(outStack.isEmpty()){
                    while(!inStack.isEmpty()){
                        outStack.push(inStack.pop());
                    }
                }
            }
        }

        public static void main(String[] args){
            MyDeque queue=new MyDeque();

            queue.push(1);
            queue.push(2);

            System.out.println(queue.peek());  // 1
            System.out.println(queue.pop());   // 1
            System.out.println(queue.empty()); // false
        }
    }
}
