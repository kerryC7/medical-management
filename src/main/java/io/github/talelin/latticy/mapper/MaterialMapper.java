package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.MaterialDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 必备材料mapper接口
 */
@Repository
public interface MaterialMapper extends BaseMapper<MaterialDO> {

    /**
     * 根据名称查询材料
     * @param name 材料名称
     * @return 材料数据对象
     */
    List<MaterialDO> selectByName(@Param("name") String name);
}
