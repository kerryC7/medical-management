package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.DoctorDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医师mapper接口
 */
@Repository
public interface DoctorMapper extends BaseMapper<DoctorDO> {

    /**
     * 根据医生姓名查询医生
     * @param name 医生姓名
     * @return 医生数据对象列表
     */
    List<DoctorDO> selectByName(@Param("name") String name);

    /**

     * @param hospital 医院名称
     * @return 医生数据对象列表
     */
    List<DoctorDO> selectByHospital(@Param("hospital") String hospital);

    /**
     * 根据科室查询医生
     * @param department 科室名称
     * @return 医生数据对象列表
     */
    List<DoctorDO> selectByDepartment(@Param("department") String department);

    /**
     * 根据医生ID查询医生信息
     * @param id 医生ID
     * @return 医生数据对象
     */
    DoctorDO selectById(@Param("id") Integer id);

    /**
     * 根据医生姓名进行模糊查询
     * @param q 查询关键字
     * @return 医生数据对象列表
     */
    List<DoctorDO> selectByNameLikeKeyword(@Param("q") String q);
}
