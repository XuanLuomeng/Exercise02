package week4.pojo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Student {
    private Integer No;
    private String Name;
    private String Native;
    private LocalDate Birthday;

    public Student() {
    }

    public Student(Integer no, String name, String aNative, LocalDate birthday) {
        No = no;
        Name = name;
        Native = aNative;
        Birthday = birthday;
    }

    public Integer getNo() {
        return No;
    }

    public void setNo(Integer no) {
        No = no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNative() {
        return Native;
    }

    public void setNative(String aNative) {
        Native = aNative;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "No=" + No +
                ", Name='" + Name + '\'' +
                ", Native='" + Native + '\'' +
                ", Birthday=" + Birthday +
                '}';
    }
}