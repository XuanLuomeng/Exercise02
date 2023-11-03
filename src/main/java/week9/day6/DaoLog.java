package week9.day6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:39
 */
public class DaoLog implements InvocationHandler {
    private Date date;
    private Object object;

    public DaoLog(){}

    public DaoLog(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        Object result = method.invoke(this.object, args);
        afterInvoke();
        return result;
    }

    private void afterInvoke() {
        System.out.println("调用结束!");
    }

    private void beforeInvoke() {
        date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = dateFormat.format(this.date);
        System.out.println("调用时间:" + format);
    }
}
