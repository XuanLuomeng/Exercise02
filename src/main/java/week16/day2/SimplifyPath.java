package week16.day2;

import week2.day14.BubbleSort.List;

import java.util.ArrayList;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description 简化路径
 * @date 2025/9/28 15:40
 *
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中规则如下：
 *
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * 返回的 简化路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<>();

        for(String str: path.split("/")){
            if(str.equals("..")){
                if(!list.isEmpty()){
                    list.remove(list.size()-1);
                }
            }else if(!str.equals(".") && !str.isEmpty()){
                list.add(str);
            }
        }

        return "/" + String.join("/", list);
    }
}
