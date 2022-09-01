package day03.sort.dollarsAndChickens;

public class Hundred1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int cock = 0;
        int hen = 0;
        int chick = 0;
        for (cock = 0; cock <= 100; cock++) {
            for (hen = 0; hen <= 100 - cock; hen++) {
                for (chick = 0; chick <= 100 - cock - hen; chick = chick + 3) {
                    if ((cock + hen + chick) == 100 && (cock * 5 + hen * 3 + chick / 3) == 100) {
                        System.out.println(cock + "公鸡" + hen + "母鸡" + chick + "小鸡");
                        continue;
                    }
                }
            }
        }
        System.out.println("用时：" + (System.currentTimeMillis() - start) + "ms");
    }
}
