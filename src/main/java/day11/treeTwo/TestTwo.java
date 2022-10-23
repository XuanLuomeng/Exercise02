package day11.treeTwo;

public class TestTwo {
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
        show(btNode0);
    }

    public static void show(BTNode btNode){
        System.out.println(btNode.data);
        if(btNode.lchild!=null){
            show(btNode.lchild);
        }
        if (btNode.rchild!=null){
            show(btNode.rchild);
        }
    }
}
