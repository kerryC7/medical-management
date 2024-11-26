package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.drug.CreateOrUpdateDrugDTO;
import io.github.talelin.latticy.model.DrugDO;
import io.github.talelin.latticy.service.DrugService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 药品控制器
 */
@RestController
@RequestMapping("/v1/drug")
@Validated
public class DrugController {

    @Autowired
    private DrugService drugService;

    /**
     * 获取指定ID的药品信息
     */
    @GetMapping("/{id}")
    public DrugDO getDrug(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        DrugDO drug = drugService.getById(id);
        if (drug == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return drug;
    }

    /**
     * 获取所有药品信息
     */
    @GetMapping("")
    public List<DrugDO> getDrugs() {
        return drugService.findAll();
    }

    /**
     * 根据关键字查询药品信息
     */
    @GetMapping("/search")
    public List<DrugDO> searchDrug(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return drugService.getDrugByKeyword("%" + q + "%");
    }

    /**
     * 创建新的药品记录
     */
    @PostMapping("")
    public CreatedVO createDrug(@RequestBody @Validated CreateOrUpdateDrugDTO validator) {
        drugService.createDrug(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的药品信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updateDrug(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                @RequestBody @Validated CreateOrUpdateDrugDTO validator) {
        DrugDO drug = drugService.getById(id);
        if (drug == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        drugService.updateDrug(drug, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的药品记录
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除药品", module = "药品管理")
    public DeletedVO deleteDrug(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        DrugDO drug = drugService.getById(id);
        if (drug == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        drugService.deleteById(drug.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
