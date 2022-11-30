package week2.day08.linkedListPojo;

public class MultinomialLinkNode {
    int coef;//系数
    int index;//指数
    MultinomialLinkNode next;

    public MultinomialLinkNode() {
        next = null;
    }

    public MultinomialLinkNode(int coef, int index) {
        this.coef = coef;
        this.index = index;
        next = null;
    }

    public MultinomialLinkNode getNext() {
        return next;
    }

    public void addcoef(int coef) {
        this.coef += coef;
    }
}
