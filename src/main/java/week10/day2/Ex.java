package week10.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LuoXuanwei
 * @date 2023/12/5 19:36
 */
public class Ex {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int year, month, day;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入年：");
        year = Integer.parseInt(br.readLine());
        System.out.println("输入月：");
        month = Integer.parseInt(br.readLine());
        System.out.println("输入日：");
        day = Integer.parseInt(br.readLine());
        String nextday = Ex.nextDate(year, month, day);
        System.out.println("下一天为" + nextday);
    }

    public static String nextDate(int y, int m, int d) {
        int year, month, day;
        year = y;
        month = m;
        day = d;
        String result = new String();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (day == 31) {
                    day = 1;
                    month = month + 1;
                } else {
                    day = day + 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30) {
                    day = 1;
                    month = month + 1;
                } else if (day == 31) {
                    System.out.println("无效输入日期！");
                } else {
                    day = day + 1;
                }
                break;
            case 12:
                if (day == 31) {
                    day = 1;
                    month = 1;
                    year = year + 1;
                } else if (day < 31) {
                    day = day + 1;
                }
                break;
            case 2: {
                if (day == 28) {
                    if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                        day = 29;
                    } else {
                        day = 1;
                        month = 3;
                    }
                } else if (day == 29) {
                    day = 1;
                    month = 3;
                } else if (day < 28) {
                    day = day + 1;
                } else {
                    result = "无效范围";
                }
            }
            break;
            default:
        }

        if (year >= 1950 && year <= 2020 && month <= 12 && month >= 1
                && day <= 31 && day >= 1) {
            StringBuilder months = new StringBuilder();
            StringBuilder days = new StringBuilder();
            if (month < 10) {
                months = months.append(0).append(month);
            } else {
                months = months.append(month);
            }
            if (day < 10) {
                days = days.append(0).append(day);
            } else {
                days = days.append(day);
            }
            StringBuilder resultB = new StringBuilder().append(year).append(months).append(days);
            result = resultB.toString();
        } else if (year < 19500 || year > 2020) {
            result = "年的值不在指定范围内";
        } else if (month > 12 || month < 1) {
            result = "月的值不在指定范围内";
        } else if (day > 31 || day < 1) {
            result = "日的值不在指定范围内";
        } else {
            result = null;
        }
        return result;
    }
}
