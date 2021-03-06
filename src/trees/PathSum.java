package trees;

import java.util.Stack;

/**
 * Created by Rachana Rao on 12/24/2016.
 */
public class PathSum {
    public static void main(String[] args) {
       int[] temp = {20, 10, 30, 5, 15, 25, 35, 4, 6, 14, 16, 24, 26, 34, 36};
     //   int[] temp = {1000,200};
        TreeNode a = TreeNode.getTreeNode(temp);
        PathSum pathSum = new PathSum();
        int b = 100;
        int i = pathSum.pathSum(a, b);
        System.out.println(i);
    }

    private int pathSum(TreeNode a, int b) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        TreeNode prev;
        TreeNode node = a;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty())
                break;
            else {
                prev = current;
                current = stack.peek();
                if (current.left == null && current.right == null) {
                    if (checkSum(stack) == b)
                        return 1;
                    stack.pop();
                } else {
                    if (prev == current.right) {
                        stack.pop();
                    }else if (current.right != null) {
                        node = current.right;
                    }
                    if(current.right == null)
                        stack.pop();
                }
            }
        }
        return 0;
    }

    private int checkSum(Stack<TreeNode> stack) {
        Object[] temp = stack.toArray();
        int sum = 0;
        for (Object o : temp) {
            sum+=((TreeNode) o).val;
        }
        return sum;
    }
}
