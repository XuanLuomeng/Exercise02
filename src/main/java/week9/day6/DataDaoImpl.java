package week9.day6;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:37
 */
public class DataDaoImpl implements DataDao{
    @Override
    public boolean selectDataById(String dataId) {
        if (dataId.equals("008")) {
            System.out.println("数据id:" + dataId + "\t访问成功");
            return true;
        } else {
            System.out.println("数据id:" + dataId + "\t访问失败");
            return false;
        }
    }
}
