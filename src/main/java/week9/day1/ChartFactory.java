package week9.day1;

/**
 * @author LuoXuanwei
 * @date 2023/9/13 19:11
 */
public class ChartFactory {
    public static Chart getChart(String type){
        if (type.equals("HistogramChart")){
            return new HistogramChart();
        }else if (type.equals("LineChart")){
            return new LineChart();
        }else if (type.equals("PieChart")){
            return new PieChart();
        }else {
            return new Chart();
        }
    }
}
