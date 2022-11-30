package week2.day11.treeThree;

public class TestThree {
    public static void main(String[] args) {
        BTNode<String> btNode0 = new BTNode<>("A");
        BTNode<String> btNode1 = new BTNode<>("B");
        BTNode<String> btNode2 = new BTNode<>("C");
        BTNode<String> btNode3 = new BTNode<>("D");
        BTNode<String> btNode4 = new BTNode<>("E");
        BTNode<String> btNode5 = new BTNode<>("F");
        BTNode<String> btNode6 = new BTNode<>("G");
        btNode0.lchild = btNode1;
        btNode0.rchild = btNode2;
        btNode1.lchild = btNode3;
        btNode3.rchild = btNode6;
        btNode2.lchild = btNode4;
        btNode2.rchild = btNode5;
        System.out.print("前序遍历：");
        preorderShow(btNode0);
        System.out.println();
        System.out.print("后续遍历：");
        epilogueShow(btNode0);
        System.out.println();
        System.out.print("中序遍历：");
        inorderTraversal(btNode0);
        System.out.println();
    }

    public static void preorderShow(BTNode btNode) {
        System.out.print(btNode.data + "\t");
        if (btNode.lchild != null) {
            preorderShow(btNode.lchild);
        }
        if (btNode.rchild != null) {
            preorderShow(btNode.rchild);
        }
    }

    public static void epilogueShow(BTNode btNode) {
        if (btNode.lchild != null) {
            epilogueShow(btNode.lchild);
        }
        if (btNode.rchild != null) {
            epilogueShow(btNode.rchild);
        }
        System.out.print(btNode.data + "\t");
    }

    public static void inorderTraversal(BTNode btNode) {
        if (btNode.lchild != null) {
            epilogueShow(btNode.lchild);
        }
        System.out.print(btNode.data + "\t");
        if (btNode.rchild != null) {
            epilogueShow(btNode.rchild);
        }
    }

}
