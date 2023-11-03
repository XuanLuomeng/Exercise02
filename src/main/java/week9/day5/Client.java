package week9.day5;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:13
 */
public class Client {
    public static void main(String[] args) {
        Searcher searcher;
        searcher = (Searcher) XMLUtil.getBean();
        String result = searcher.doSearch("zhangsan","gduf");
        System.out.println("result:"+result);
    }
}
