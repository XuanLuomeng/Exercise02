package week9.day5;

/**
 * @author LuoXuanwei
 * @date 2023/10/19 0:05
 */
public class ProxySearcher implements Searcher {
    private RealSearcher searcher;
    private AccessValidator validator;
    private Logger logger;

    public boolean validate(String userId) {
        validator = new AccessValidator();
        return validator.validate(userId);
    }

    @Override
    public String doSearch(String userId, String keyword) {
        searcher = new RealSearcher();
        if (this.validate(userId)) {
            String s = searcher.doSearch(userId, keyword);
            this.log(userId);
            return s;
        }
        return null;
    }

    private void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }
}
