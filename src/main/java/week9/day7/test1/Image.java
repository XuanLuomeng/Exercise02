package week9.day7.test1;

/**
 * @author LuoXuanwei
 * @date 2023/11/1 20:35
 */
public abstract class Image {
    protected ImageImp imageImp;

    public void setImageImp(ImageImp imageImp) {
        this.imageImp = imageImp;
    }

    abstract void parseFile(String fileName);
}
