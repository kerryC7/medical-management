package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.SalesLocationDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 销售地点Mapper接口
 */
@Repository
public interface SalesLocationMapper extends BaseMapper<SalesLocationDO> {

    /**
     * 根据销售地点名称模糊查询销售地点
     * @param name 销售地点名称
     * @return 销售地点数据对象列表
     */
    List<SalesLocationDO> selectByNameLikeKeyword(@Param("name") String name);
}
