package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 根据id查询员工信息
     *
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);

    /**
     * 获取员工以及所对应的部门信息
     *
     * @param empId
     * @return
     */
    Emp getEmpAmdDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 通过分步查询查询员工以及所对应的部门信息的第一步
     *
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 通过分步查询查询部门以及部门中的员工信息的第二步
     * @param dept_id
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer dept_id);
}
