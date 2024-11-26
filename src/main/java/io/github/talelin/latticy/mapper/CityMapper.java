package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.CityDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 城市Mapper接口
 */
@Repository
public interface CityMapper extends BaseMapper<CityDO> {

    /**
     * 根据城市名称模糊查询城市列表
     * @param name 查询关键字
     * @return 城市数据对象列表
     */
    List<CityDO> selectByNameLikeKeyword(@Param("name") String name);

    /**
     * 根据城市名称查询城市
     * @param name 城市名称
     * @return 城市数据对象
     */
    List<CityDO> selectByName(@Param("name") String name);
}
