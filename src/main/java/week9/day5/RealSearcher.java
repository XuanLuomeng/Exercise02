package week9.day5;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:03
 */
public class RealSearcher implements Searcher {
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println("用户:" + userId + "\t使用关键字:" + keyword + "\t查询商务信息!");
        return "返回的内容";
    }
}
