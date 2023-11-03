package week9.day5;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:27
 */
public class NewRealSearcher implements Searcher{
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println("******新功能******");
        System.out.println("用户:" + userId + "\t使用关键字:" + keyword + "\t查询游戏信息!");
        return "返回的游戏内容";
    }
}
