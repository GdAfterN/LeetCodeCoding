package 回溯;
import java.util.*;
// TODO 重要的题
public class 括号生成_22 {
    static class Solution {
        static List<String> res = new ArrayList<>();

        static List<String> generateParenthesis(int n) {
            res.clear();
            traverse(n, 0, 0, new StringBuilder());
            return res;
        }

        static void traverse(int n, int left, int right, StringBuilder sb) {
            if (left == n && right == n) res.add(sb.toString());
            if (left < n) {
                sb.append('(');
                traverse(n, left + 1, right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (left > right) {
                sb.append(')');
                traverse(n, left, right + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public static void main(String[] args){
            System.out.println(generateParenthesis(3));
        }
    }
}
