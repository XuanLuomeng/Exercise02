package week2.day08.linkedListPojo;

public class MultinomialLinkListClass {
    MultinomialLinkNode head;
    public MultinomialLinkListClass(){
        head = new MultinomialLinkNode();
        head.next = null;
    }
    public MultinomialLinkListClass(int[] coef,int [] index){
        head = new MultinomialLinkNode();
        head.next = null;
        MultinomialLinkNode node;
        for (int len = 0; len < coef.length; len++) {
            node = new MultinomialLinkNode(coef[len],index[len]);
            node.next = head.next;
            head.next = node;
        }
    }

    public MultinomialLinkNode getNode(int i) {
        MultinomialLinkNode p = head;
        int j = -1;
        while (j < i) {
            j++;
            p = p.next;
        }
        return p;
    }

    public MultinomialLinkNode getNodeByIndex(int index) {
        MultinomialLinkNode p = head;
        int j = p.index;
        while (j != index) {
            p = p.next;
            j = p.index;
        }
        return p;
    }

    public int getSize() {
        MultinomialLinkNode p = head;
        int cnt = 0;
        while (p.next != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    //Get index and coefficient
    public int[] getElem(int i) {
        int size = getSize();
        if (i < 0 || i >= size) {
            throw new RuntimeException("Position i is not within the valid range");
        } else {
            MultinomialLinkNode elem = getNode(i);
            int[] nums = new int[]{elem.coef,elem.index};
            return nums;
        }
    }

    /**
     * Check whether the linked list of the response index exists
     * @param index
     * @return
     */
    public boolean isExitIndex(int index){
        for (int size = 0; size < getSize(); size++) {
            if(getNode(size).index==index){
                return true;
            }
        }
        return false;
    }

    public void add(MultinomialLinkNode linkNode){
        if(isExitIndex(linkNode.index)){
            getNodeByIndex(linkNode.index).addcoef(linkNode.coef);
        }else {
            MultinomialLinkNode last = getNode(getSize() - 1);
            linkNode.next = last.next;
            last.next = linkNode;
        }
    }
}
