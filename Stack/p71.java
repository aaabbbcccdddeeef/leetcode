import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class p71 {
    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("");
        String[] lst = path.split("/");
        for (String s : lst) {
            if (s.equals("") || s.equals("."))
                continue;
            if (s.equals("..")) {
                if (stack.peek() != "")
                    stack.pop();
            } else {
                stack.push(s);
            }
        }
        List<String> ans=new ArrayList<>();
        stack.pollLast();
        while(!stack.isEmpty()){
            ans.add(stack.pollLast());
        }
        for(String sk:ans){
            System.out.println("s:"+sk);
        }
        return "/" + String.join("/", ans);
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../."));
    }
}
