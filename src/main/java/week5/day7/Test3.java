package week5.day7;

import sun.applet.Main;

/**
 * @author LuoXuanwei
 * @date 2023/5/30 19:20
 */
public class Test3 extends Thread implements Runnable{
    @Override
    public void run(){
        System.out.println("this is run()");
    }

    public static void main(String[] args){
//        Thread thread = new Thread(new Main());
//        thread.start();
    }
}
