package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.policy.CreateOrUpdatePolicyDTO;
import io.github.talelin.latticy.model.PolicyDO;
import io.github.talelin.latticy.service.PolicyService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 政策控制器
 */
@RestController
@RequestMapping("/v1/policy")
@Validated
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/{id}")
    public PolicyDO getPolicy(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        PolicyDO policy = policyService.getById(id);
        if (policy == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return policy;
    }

    @GetMapping("")
    public List<PolicyDO> getPolicies() {
        return policyService.findAll();
    }

    @GetMapping("/search")
    public List<PolicyDO> searchPolicy(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return policyService.getPolicyByKeyword("%" + q + "%");
    }

    @PostMapping("")
    public CreatedVO createPolicy(@RequestBody @Validated CreateOrUpdatePolicyDTO validator) {
        policyService.createPolicy(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    @PutMapping("/{id}")
    public UpdatedVO updatePolicy(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                  @RequestBody @Validated CreateOrUpdatePolicyDTO validator) {
        PolicyDO policy = policyService.getById(id);
        if (policy == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        policyService.updatePolicy(policy, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除政策", module = "政策管理")
    public DeletedVO deletePolicy(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        PolicyDO policy = policyService.getById(id);
        if (policy == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        policyService.deleteById(policy.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
