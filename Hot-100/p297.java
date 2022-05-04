import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class p297 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(23);
        a.right = new TreeNode(31);
        System.out.println(serialize(a));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serializeTN(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> lst = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeTN(lst);
    }

    private static void serializeTN(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("None,");
        } else {
            sb.append(String.valueOf(root.val)).append(",");
            serializeTN(root.left, sb);
            serializeTN(root.right, sb);
        }
    }

    private static TreeNode deserializeTN(List<String> lst) {
        if (lst.get(0).equals("None")) {
            lst.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(lst.get(0)));
        lst.remove(0);
        root.left = deserializeTN(lst);
        root.right = deserializeTN(lst);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));