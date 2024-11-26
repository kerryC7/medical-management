package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.DepartmentDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 科室mapper接口
 */
@Repository
public interface DepartmentMapper extends BaseMapper<DepartmentDO> {

    /**
     * 根据科室名称模糊查询科室列表
     * @param q 查询关键字
     * @return 科室数据对象列表
     */
    List<DepartmentDO> selectByDepartmentNameLikeKeyword(@Param("q") String q);

    /**
     * 根据科室名称查询科室
     * @param departmentName 科室名称
     * @return 科室数据对象列表
     */
    List<DepartmentDO> selectByDepartmentName(@Param("departmentName") String departmentName);

    /**
     * 获取所有科室
     * @return 所有科室的列表
     */
    List<DepartmentDO> selectAll();
}
