package day01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testTiem {
    public static void main(String[] args) throws ParseException {
        Date pushdate = new Date();
        String timeStr = "2022-10-14 16:58";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String now = simpleDateFormat.format(pushdate);
        long nowtime = simpleDateFormat.parse(now).getTime();
        System.out.println(timeStr);
        System.out.println(nowtime);
        System.out.println(now);

        long time = simpleDateFormat.parse(timeStr).getTime();
        System.out.println(time);

        long cha = nowtime - time;

        System.out.println(cha/1000/60+"分钟前");
    }
}
