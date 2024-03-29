package week2.day12;


import java.util.Arrays;

public class CreateTreeByInorderAndPostorder {
    private static int findNode(String[] array, String data) {
        for (int size = 0; size < array.length; size++) {
            if (array[size].equals(data)) {
                return size;
            }
        }
        return -1;
    }

    private static TreeNode buildTree(String[] inorder, String[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        //Create the root node based on the value of the subsequent root
        String rootData = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootData);

        //Find the index of the root in the middle order
        int rootIndex = findNode(inorder, rootData);

        //Cut out the inorder and postorder of the left subtree
        String[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        String[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootIndex);
        root.lifeTree = buildTree(leftInorder, leftPostorder);

        //Cut out the inorder and postorder of the right subtree
        String[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        String[] rightPostorder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
        root.rightTree = buildTree(rightInorder, rightPostorder);

        return root;
    }

    public static void show(TreeNode Node) {
        System.out.println(Node.data);
        if (Node.lifeTree != null) {
            show(Node.lifeTree);
        }
        if (Node.rightTree != null) {
            show(Node.rightTree);
        }
    }

    public static void main(String[] args) {
        String[] inorder = new String[]{"C", "D", "B", "A", "E"};
        String[] postorder = new String[]{"D", "C", "B", "E", "A"};
        TreeNode treeNode = buildTree(inorder, postorder);
        show(treeNode);
        System.out.println("创建成功");
    }
}
