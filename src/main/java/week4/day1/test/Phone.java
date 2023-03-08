package week4.day1.test;

public class Phone implements Soundable {
    @Override
    public void incVolume() {
        System.out.println("增大手机音量");
    }

    @Override
    public void decVolume() {
        System.out.println("减小手机音量");
    }

    @Override
    public void stopSound() {
        System.out.println("关闭手机");
    }

    @Override
    public void playSound() {
        System.out.println("打开手机");
    }
}
