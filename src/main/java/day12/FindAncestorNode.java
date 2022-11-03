package day12;

import java.util.Arrays;

public class FindAncestorNode {
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

    public static TreeNode findTreeNode(TreeNode node, String data) {
        TreeNode signTree = node;
        if (node.lifeTree != null) {
            TreeNode lifeTree = findTreeNode(node.lifeTree, data);
            signTree = lifeTree.data.equals(data) ? lifeTree : signTree;
        }
        if (node.rightTree != null) {
            TreeNode rightTree = findTreeNode(node.rightTree, data);
            signTree = rightTree.data.equals(data) ? rightTree : signTree;
        }
        return signTree;
    }

    public static void findAncestor(TreeNode node1, TreeNode node2) {
        TreeNode node = null;
        TreeNode nodeOne = node1;
        TreeNode nodeTwo = node2;
        while (true) {
            nodeOne = nodeOne.fatherTree;
            while (true) {
                nodeTwo = nodeTwo.fatherTree;
                if (nodeOne == nodeTwo) {
                    node = nodeOne;
                    break;
                }
                if (nodeTwo.fatherTree == null) {
                    break;
                }
            }
            if (nodeOne.fatherTree == null) {
                break;
            }
            if (node != null) {
                break;
            }
        }
        if (node == null) {
            System.out.println(node1 + "和" + node2 + "无共同祖先");
        } else {
            System.out.println(node1.data+"和"+node2.data+"的共同祖先为：" + node.data);
        }
    }

    public static void main(String[] args) {
        String[] inorder = new String[]{"4", "7", "3", "1", "10"};
        String[] postorder = new String[]{"7", "4", "3", "10", "1"};
        TreeNode treeNode = buildTree(inorder, postorder);
        setFatherNode(treeNode, null);
        System.out.println("创建成功");

        findAncestor(findTreeNode(treeNode, "4"), findTreeNode(treeNode, "1"));
    }
}
