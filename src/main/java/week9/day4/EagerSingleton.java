package week9.day4;

/**
 * @author LuoXuanwei
 * @date 2023/10/11 20:36
 */
public class EagerSingleton {
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
