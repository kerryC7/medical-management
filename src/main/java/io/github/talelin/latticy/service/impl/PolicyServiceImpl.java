package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.policy.CreateOrUpdatePolicyDTO;
import io.github.talelin.latticy.mapper.PolicyMapper;
import io.github.talelin.latticy.model.PolicyDO;
import io.github.talelin.latticy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 政策服务实现类
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyMapper policyMapper;

    @Override
    public boolean createPolicy(CreateOrUpdatePolicyDTO validator) {
        PolicyDO policy = new PolicyDO();
        policy.setPolicyTitle(validator.getPolicyTitle());
        policy.setPolicyDescription(validator.getPolicyDescription());
        policy.setPolicyType(validator.getPolicyType());
        policy.setReleaseDate(validator.getReleaseDate());
        return policyMapper.insert(policy) > 0;
    }

    @Override
    public boolean updatePolicy(PolicyDO policy, CreateOrUpdatePolicyDTO validator) {
        policy.setPolicyTitle(validator.getPolicyTitle());
        policy.setPolicyDescription(validator.getPolicyDescription());
        policy.setPolicyType(validator.getPolicyType());
        policy.setReleaseDate(validator.getReleaseDate());
        return policyMapper.updateById(policy) > 0;
    }

    @Override
    public PolicyDO getById(Integer id) {
        return policyMapper.selectById(id);
    }

    @Override
    public List<PolicyDO> getPolicyByKeyword(String q) {
        return policyMapper.selectByTitleLikeKeyword(q);
    }

    @Override
    public List<PolicyDO> findAll() {
        return policyMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return policyMapper.deleteById(id) > 0;
    }
}
