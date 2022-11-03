package day12;

import java.util.Arrays;

public class FindMaxNodeAndMinNode {
    //Construct a binary tree
    private static int findNode(String[] array, String data) {
        for (int size = 0; size < array.length; size++) {
            if (array[size].equals(data)) {
                return size;
            }
        }
        return -1;
    }

    private static TreeNode buildTree(String[] inorder, String[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        //Create the root node based on the value of the subsequent root
        String rootData = preorder[0];
        TreeNode root = new TreeNode(rootData);

        //Find the index of the root in the middle order
        int rootIndex = findNode(inorder, rootData);

        //Cut out the preorder and inorder of the left subtree
        String[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        String[] leftPostorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        root.lifeTree = buildTree(leftInorder, leftPostorder);

        //Cut out the preorder and inorder of the right subtree
        String[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        String[] rightPostorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        root.rightTree = buildTree(rightInorder, rightPostorder);

        return root;
    }

    //set fatherNode
    public static void setFatherNode(TreeNode node, TreeNode fatherNode) {
        if (fatherNode == null) {
            node.fatherTree = null;
        } else {
            node.fatherTree = fatherNode;
        }
        if (node.lifeTree != null) {
            setFatherNode(node.lifeTree, node);
        }
        if (node.rightTree != null) {
            setFatherNode(node.rightTree, node);
        }
    }

    public static TreeNode findMax(TreeNode node) {
        TreeNode signTree = node;
        if (node.lifeTree != null) {
            TreeNode lifeTree = findMax(node.lifeTree);
            signTree = Integer.parseInt(node.data) > Integer.parseInt(lifeTree.data) ? node : lifeTree;
        }
        if (node.rightTree != null) {
            TreeNode rightTree = findMax(node.rightTree);
            signTree = Integer.parseInt(node.data) > Integer.parseInt(rightTree.data) ? node : rightTree;
        }
        return signTree;
    }

    public static TreeNode findMin(TreeNode node) {
        TreeNode signTree = node;
        if (node.lifeTree != null) {
            TreeNode lifeTree = findMin(node.lifeTree);
            signTree = Integer.parseInt(node.data) < Integer.parseInt(lifeTree.data) ? node : lifeTree;
        }
        if (node.rightTree != null) {
            TreeNode rightTree = findMin(node.rightTree);
            signTree = Integer.parseInt(node.data) < Integer.parseInt(rightTree.data) ? node : rightTree;
        }
        return signTree;
    }

    public static void findFatherNode(TreeNode node) {
        System.out.print("-->" + node.data);
        if (node.fatherTree != null) {
            findFatherNode(node.fatherTree);
        }
    }

    public static void main(String[] args) {
        String[] inorder = new String[]{"4", "7", "3", "1", "10"};
        String[] postorder = new String[]{"7", "4", "3", "10", "1"};
        TreeNode treeNode = buildTree(inorder, postorder);
        setFatherNode(treeNode, null);
        System.out.println("创建成功");

        System.out.println("最大值节点逆序输出：");
        findFatherNode(findMax(treeNode));
        System.out.println();
        System.out.println("最小值节点逆序输出：");
        findFatherNode(findMin(treeNode));
    }
}
