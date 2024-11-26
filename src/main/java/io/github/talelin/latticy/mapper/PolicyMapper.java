package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.PolicyDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 政策信息Mapper接口
 */
@Repository
public interface PolicyMapper extends BaseMapper<PolicyDO> {

    /**
     * 根据标题模糊查询政策
     * @param q 查询关键字
     * @return 政策列表
     */
    List<PolicyDO> selectByTitleLikeKeyword(@Param("q") String q);

    /**
     * 查询所有政策
     * @return 政策列表
     */
    List<PolicyDO> selectAll();
}
