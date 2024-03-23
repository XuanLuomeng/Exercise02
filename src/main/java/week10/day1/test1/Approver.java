package week10.day1.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/22 22:46
 */
public abstract class Approver {
    protected Approver successor;
    protected String name;

    public Approver(String name){
        this.name = name;
    }

    public void setSuccessor(Approver successor){
        this.successor = successor;
    }

    public abstract void processRequest(PurchaseRequest request);
}
