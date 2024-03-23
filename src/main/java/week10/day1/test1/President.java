package week10.day1.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/22 22:56
 */
public class President extends Approver{
    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 500000) {
            System.out.println("领导" + this.name + "\t单号:" + request.getNumber() + "\t金额:" + request.getAmount() + "元\t目的:" + request.getPurpose());
        } else {
            this.successor.processRequest(request);
        }
    }
}
