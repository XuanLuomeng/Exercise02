package week3.day18;

public class BinaryTree {
    public BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTree(int[] arrays) {
        //Build a binary sort tree from an array
        if (arrays.length != 0 && arrays != null) {
            this.root = new BinaryTreeNode(arrays[0]);
            for (int i = 1; i < arrays.length; i++) {
                add(arrays[i]);
            }
        }
    }

    public void add(int data) {
        BinaryTreeNode node = this.root;
        if (node == null) {
            this.root = new BinaryTreeNode(data);
        } else {
            while (node != null) {
                /**
                 * Larger than the node is put into the left subtree of the node,
                 * and the opposite is put into the right subtree of the node
                 */
                if (node.data > data) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new BinaryTreeNode(data);
                        node.left.father = node;
                        break;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new BinaryTreeNode(data);
                        node.right.father = node;
                        break;
                    }
                }
            }
        }
    }

    public BinaryTreeNode findMaxOrMin(BinaryTreeNode treeNode, boolean flat) {
        BinaryTreeNode node = treeNode;
        //flat is true to find the largest left subtree, and flat is false to find the smallest right subtree
        if (flat == true) {
            if (node.left != null) {
                node = node.left;
                while (node.right != null) {
                    node = node.right;
                }
            }
        } else {
            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
            }
        }
        return node;
    }

    public BinaryTreeNode findNode(int data) {
        BinaryTreeNode node = this.root;
        if (node == null) {
            return null;
        } else {
            while (node != null) {
                if (node.data > data) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        return null;
                    }
                } else if (node.data < data) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        return null;
                    }
                } else {
                    //Prevent identical values in the left and right subtrees
                    node = exclude(node);
                    return node;
                }
            }
            return node;
        }
    }

    //Exclude identical values
    public BinaryTreeNode exclude(BinaryTreeNode node) {
        /**
         * The purpose of this method is to prevent deadlocks during deletion.
         * According to this kind of algorithm, the left subtree does not have the same value as the parent node
         * under normal circumstances, so when the left and right subtrees are the same as the parent node,
         * the left subtree node is returned first.
         */
        BinaryTreeNode result = node;
        if (node.right != null) {
            if (node.right.data == node.data) {
                result = exclude(node.right);
            }
        }
        if (node.left != null) {
            if (node.left.data == node.data) {
                result = exclude(node.left);
            }
        }
        return result;
    }

    public boolean deleteNode(int data) {
        /**
         * First, we find the number node we want to remove.
         * Second, determine whether the node is a leaf node, if it is a leaf node, it will be deleted directly,
         * otherwise continue to the third operation.
         * Third, according to whether the node has left and right nodes
         * (both of which are sometimes replaced by the maximum value of the left subtree),
         * the position of the node is replaced by the maximum value of the left subtree or
         * the minimum value of the right subtree.
         */
        BinaryTreeNode node = findNode(data);
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (node.father.left == node) {
                node.father.left = null;
            } else {
                node.father.right = null;
            }
            return true;
        }
        BinaryTreeNode replace = null;
        if (node.left != null) {
            replace = findMaxOrMin(node, true);
            node.data = replace.data;
            deleteNode(replace.data);
        } else {
            replace = findMaxOrMin(node, false);
            node.data = replace.data;
            deleteNode(replace.data);
        }
        return true;
    }

    //Output the left child first, and the right child later
    public void show(BinaryTreeNode node) {
        System.out.print(node.data + ",");
        if (node.left != null) {
            show(node.left);
        }
        if (node.right != null) {
            show(node.right);
        }
    }
}
