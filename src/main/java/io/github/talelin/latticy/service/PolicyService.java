package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.policy.CreateOrUpdatePolicyDTO;
import io.github.talelin.latticy.model.PolicyDO;

import java.util.List;

/**
 * 政策信息服务接口
 */
public interface PolicyService {

    /**
     * 创建政策
     * @param validator 创建政策的DTO
     * @return 是否创建成功
     */
    boolean createPolicy(CreateOrUpdatePolicyDTO validator);

    /**
     * 更新政策
     * @param policy 政策数据对象
     * @param validator 创建或更新的DTO
     * @return 是否更新成功
     */
    boolean updatePolicy(PolicyDO policy, CreateOrUpdatePolicyDTO validator);

    /**
     * 获取政策
     * @param id 主键id
     * @return 政策数据对象
     */
    PolicyDO getById(Integer id);

    /**
     * 根据关键字查询政策
     * @param q 查询关键字
     * @return 政策列表
     */
    List<PolicyDO> getPolicyByKeyword(String q);

    /**
     * 查询所有政策
     * @return 政策列表
     */
    List<PolicyDO> findAll();

    /**
     * 删除政策
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
