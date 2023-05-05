package week4.pojo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private int sNo;
    private String sName;
    private String sNative;
    private LocalDate sBirthday;

    public Student(int sNo, String sName, String sNative, LocalDate sBirthday) {
        this.sNo = sNo;
        this.sName = sName;
        this.sNative = sNative;
        this.sBirthday = sBirthday;
    }
}
