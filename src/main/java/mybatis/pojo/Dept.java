package mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    private Integer deptId;
    private String deptName;
    private List<Emp> emps;

    public Dept() {
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
}
