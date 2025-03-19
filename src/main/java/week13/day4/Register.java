package week13.day4;

/**
 * @author LuoXuanwei
 * @version 1.0
 * @description TODO
 * @date 2025/3/7 00:19
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 记牌器
 */
public class Register {
    private Map<String, Integer> deck;

    private void init() {
        deck = new HashMap<>();
        deck.put("A", 4);
        deck.put("2", 4);
        deck.put("3", 4);
        deck.put("4", 4);
        deck.put("5", 4);
        deck.put("6", 4);
        deck.put("7", 4);
        deck.put("8", 4);
        deck.put("9", 4);
        deck.put("10", 4);
        deck.put("J", 4);
        deck.put("Q", 4);
        deck.put("K", 4);
        deck.put("BK", 1);
        deck.put("SK", 1);
    }

    public Register() {
        init();
    }

    public void draw(String card) {
        if (deck.containsKey(card)) {
            deck.put(card, deck.get(card) - 1);
        }
        if (deck.get(card) == 0) {
            deck.remove(card);
        }
        this.print();
    }

    public void print() {
        for (Map.Entry<String, Integer> entry : deck.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
