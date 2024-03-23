package week10.day1.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/22 22:57
 */
public class Congress extends Approver{
    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("领导会议\t单号:" + request.getNumber() + "\t金额:" + request.getAmount() + "元\t目的:" + request.getPurpose());
    }
}
