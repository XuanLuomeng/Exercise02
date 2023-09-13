package week9.day1;

/**
 * @author LuoXuanwei
 * @date 2023/9/13 19:14
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Chart chart;
        String type = XMLUtil.getChartType();
        chart = ChartFactory.getChart(type);
        chart.display();
    }
}
