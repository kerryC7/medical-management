package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.material.CreateOrUpdateMaterialDTO;
import io.github.talelin.latticy.model.MaterialDO;
import io.github.talelin.latticy.service.MaterialService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 必备材料控制器
 */
@RestController
@RequestMapping("/v1/material")
@Validated
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /**
     * 获取指定ID的必备材料
     */
    @GetMapping("/{id}")
    public MaterialDO getMaterial(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        MaterialDO material = materialService.getById(id);
        if (material == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return material;
    }

    /**
     * 获取所有必备材料
     */
    @GetMapping("")
    public List<MaterialDO> getMaterials() {
        return materialService.findAll();
    }

    /**
     * 根据名称关键字查询必备材料
     */
    @GetMapping("/search")
    public List<MaterialDO> searchMaterial(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return materialService.getMaterialByKeyword("%" + q + "%");
    }

    /**
     * 创建新的必备材料
     */
    @PostMapping("")
    public CreatedVO createMaterial(@RequestBody @Validated CreateOrUpdateMaterialDTO validator) {
        materialService.createMaterial(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的必备材料
     */
    @PutMapping("/{id}")
    public UpdatedVO updateMaterial(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                    @RequestBody @Validated CreateOrUpdateMaterialDTO validator) {
        MaterialDO material = materialService.getById(id);
        if (material == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        materialService.updateMaterial(material, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的必备材料
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除必备材料", module = "材料管理")
    public DeletedVO deleteMaterial(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        MaterialDO material = materialService.getById(id);
        if (material == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        materialService.deleteById(material.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
