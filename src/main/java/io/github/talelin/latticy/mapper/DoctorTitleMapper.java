package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.DoctorTitleDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 职称表Mapper接口
 */
@Repository
public interface DoctorTitleMapper extends BaseMapper<DoctorTitleDO> {

    /**
     * 根据职称名称查询职称信息
     * @param titleName 职称名称
     * @return 职称数据对象列表
     */
    List<DoctorTitleDO> selectByTitleName(@Param("titleName") String titleName);

    /**
     * 根据职称ID查询职称信息
     * @param id 职称ID
     * @return 职称数据对象
     */
    DoctorTitleDO selectById(@Param("id") Integer id);

    /**
     * 查询所有职称信息
     */
   // @Select("SELECT * FROM doctor_title ")
    List<DoctorTitleDO> selectAll();
}
