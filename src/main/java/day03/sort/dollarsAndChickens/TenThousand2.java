package day03.sort.dollarsAndChickens;

public class TenThousand2 {
    public static void main(String[] args) {
        int cock = 0;
        int hen = 0;
        int chick = 0;
        long start = System.nanoTime();
        for (cock = 0; cock <= 10000; cock++) {
            for (hen = 0; hen <= 10000 - cock; hen++) {
                chick = 10000 - cock - hen;
                //若chick除于3不为0则不符合要求
                if (chick % 3 == 0) {
                    if ((cock + hen + chick) == 10000 && (cock * 5 + hen * 3 + chick / 3) == 10000) {
                        System.out.println(cock + "公鸡" + hen + "母鸡" + chick + "小鸡");
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        System.out.println("用时：" + (System.nanoTime() - start) + "ns");
    }
}
