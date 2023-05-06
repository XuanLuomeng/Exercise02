package test;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import week4.day4.ExcelUtil;
import week4.pojo.Student;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelTest {
    @Test
    public void write() throws ParseException {
        List<Student> dataList = new ArrayList<>();
        for (int i = 10; i < 20; i++) {
            Student student = new Student(21214 + i, "王五", "广东", LocalDate.of(2001, 01, 07));
            dataList.add(student);
        }
        String sheetName = "员工信息";
        String[] headerArray = new String[]{"学号", "姓名", "籍贯", "出生日期"};
        String filePath = "C:\\Users\\联想\\Desktop\\测试学生.xls";
        ExcelUtil.exportDataToExcel(new HSSFWorkbook(), sheetName, headerArray, dataList, filePath);
    }

    @Test
    public void read() {
        String filePath = "C:\\Users\\联想\\Desktop\\学生.xls";
        List<Student> students = ExcelUtil.readDataFromExcel(filePath, Student.class, 1);
        System.out.println("行数:" + students.size());
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
