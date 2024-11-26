package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.PharmaDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医药公司Mapper接口
 */
@Repository
public interface PharmaMapper extends BaseMapper<PharmaDO> {

    /**
     * 根据名称查询医药公司
     * @param name 医药公司名称
     * @return 医药公司数据对象列表
     */
    List<PharmaDO> selectByName(@Param("name") String name);

    /**
     * 根据关键字查询医药公司
     * @param q 查询关键字
     * @return 医药公司数据对象列表
     */
    List<PharmaDO> selectByKeyword(@Param("q") String q);
}
