package week11.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2024/8/2 21:11
 * <p>
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
class RandomizedSet {
    private List<Integer> list;
    private Random random = new Random();
    private HashMap<Integer, Integer> map;
    private int idx = 0;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, idx++);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            list.remove(map.get(val));
            map.remove(val);
            idx--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
