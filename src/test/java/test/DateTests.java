package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import week10.day2.Date;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author LuoXuanwei
 * @date 2023/12/5 19:39
 */
@RunWith(Parameterized.class)
public class DateTests {
    private String input1;
    private String input2;
    private String input3;
    private String expected;

    @Parameterized.Parameters
    public static Collection<?> prepareData(){
        String [][] object = {
                // 有效等价类
                {"2020","2","29","nextDate:2020-3-1"},
                {"2017","1","28","nextDate:2017-1-29"},
                {"2015","1","31","nextDate:2015-2-1"},
                {"2014","4","30","nextDate:2014-5-1"},
                {"2013","12","31","nextDate:2014-1-1"},
                // 无效等价类
                {"1949","3","1","年的值不在指定范围之内"},
                {"2021","3","1","年的值不在指定范围之内"},
                {"205%","3","1","无效范围"},
                {"1951","-1","1","月的值不在指定范围之内"},
                {"1951","13","1","月的值不在指定范围之内"},
                {"1951","1*","1","无效范围"},
                {"1951","1","-1","日的值不在指定范围之内"},
                {"2011","2","30","日的值不在指定范围之内"},
                {"2012","2","29","日的值不在指定范围之内"},
                {"2012","3","32","日的值不在指定范围之内"},
                {"2012","4","31","日的值不在指定范围之内"},
                {"2012","4","32","日的值不在指定范围之内"},
                {"2012","4","4*","无效范围"}
        };
        return Arrays.asList(object);
    }
    public DateTests(String input1,String input2,String input3,String expected){
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.expected = expected;

    }
    @Test
    public void testDate(){
        String result = Date.nextDate(input1,input2,input3);
        Assert.assertEquals(expected,result);
    }
}
