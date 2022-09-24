package mybatis.pojo;

import lombok.Data;

@Data
public class Dept {
    private Integer depId;
    private String deptName;

    public Dept() {
    }

    public Dept(Integer depId, String deptName) {
        this.depId = depId;
        this.deptName = deptName;
    }
}
