package 栈;
import java.util.*;
public class 有效的括号_20 {
    static class Solution{
        static boolean isValid(String s){
            if(s.length()==0) return false;
            Deque<Character> stack=new ArrayDeque<>();
            Map<Character,Character> map=new HashMap<>();
            map.put(')','(');
            map.put('}','{');
            map.put(']','[');
            for(char c:s.toCharArray()){
                if(!map.containsKey(c)) stack.push(c);
                else{
                    if(!stack.isEmpty()&&stack.peek()==map.get(c)) stack.pop();
                    else return false;
                }
            }
            return stack.isEmpty();
        }
        public static void main(String[] args){
            String s="()[]{}";
            System.out.println(isValid(s));
        }
    }
}
