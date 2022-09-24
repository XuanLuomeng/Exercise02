package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    /**
     * 根据id查询员工信息
     *
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 获取员工以及所对应的部门信息
     * @param empId
     * @return
     */
    Emp getEmpAmdDeptByEmpId(@Param("empId")Integer empId);
}
