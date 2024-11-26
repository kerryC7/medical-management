package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.DrugDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 药品Mapper接口
 */
@Repository
public interface DrugMapper extends BaseMapper<DrugDO> {

    /**
     * 根据药品名称模糊查询药品
     * @param q 查询关键字
     * @return 药品数据对象列表
     */
    List<DrugDO> selectByNameLikeKeyword(@Param("q") String q);

    /**
     * 根据药品名称查询药品
     * @param name 药品名称
     * @return 药品数据对象
     */
    List<DrugDO> selectByName(@Param("name") String name);
}
