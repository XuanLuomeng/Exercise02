package week10.day1.text2;

/**
 * @author LuoXuanwei
 * @date 2023/11/22 23:19
 */
public abstract class Account {
    public boolean validate(String account,String password){
        System.out.println("用户:"+account);
        System.out.println("密钥:"+password);
        if (account.equalsIgnoreCase("张三")&&password.equalsIgnoreCase("zhangsan")){
            return true;
        }else {
            return false;
        }
    }

    public abstract void calculateInterest();

    public void display(){
        System.out.println("利息展示");
    }

    public void handle(String account,String password){
        if (!validate(account,password)){
            System.out.println("用户或密码错误");
            return;
        }
        calculateInterest();
        display();
    }
}
