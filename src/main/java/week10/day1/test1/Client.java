package week10.day1.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/22 22:58
 */
public class Client {
    public static void main(String[] args) {
        Approver zs,ls,ww,meeting;
        zs = new Director("张三");
        ls = new VicePresident("李四");
        ww = new President("王五");
        meeting = new Congress("领导会议");

        zs.setSuccessor(ls);
        ls.setSuccessor(ww);
        ww.setSuccessor(meeting);

        PurchaseRequest purchaseRequest1 = new PurchaseRequest(45000,1001,"高等数学");
        zs.processRequest(purchaseRequest1);

        PurchaseRequest purchaseRequest2 = new PurchaseRequest(60000,1002,"数据结构");
        zs.processRequest(purchaseRequest2);

        PurchaseRequest purchaseRequest3 = new PurchaseRequest(160000,1003,"设计模式");
        zs.processRequest(purchaseRequest3);

        PurchaseRequest purchaseRequest4 = new PurchaseRequest(800000,1004,"计算机组成原理");
        zs.processRequest(purchaseRequest4);
    }
}
