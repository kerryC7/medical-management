package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.pharma.CreateOrUpdatePharmaDTO;
import io.github.talelin.latticy.model.PharmaDO;
import io.github.talelin.latticy.service.PharmaService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 医药公司控制器
 */
@RestController
@RequestMapping("/v1/pharma")
@Validated
public class PharmaController {

    @Autowired
    private PharmaService pharmaService;

    /**
     * 获取指定ID的医药公司信息
     */
    @GetMapping("/{id}")
    public PharmaDO getPharma(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        PharmaDO pharma = pharmaService.getById(id);
        if (pharma == null) {
            throw new NotFoundException(10022); // 可以根据需要修改异常代码
        }
        return pharma;
    }

    /**
     * 获取所有医药公司信息
     */
    @GetMapping("")
    public List<PharmaDO> getPharmas() {
        return pharmaService.findAll();
    }

    /**
     * 根据关键字查询医药公司信息
     */
    @GetMapping("/search")
    public List<PharmaDO> searchPharma(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return pharmaService.getPharmaByKeyword("%" + q + "%");
    }

    /**
     * 创建新的医药公司记录
     */
    @PostMapping("")
    public CreatedVO createPharma(@RequestBody @Validated CreateOrUpdatePharmaDTO validator) {
        pharmaService.createPharma(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的医药公司信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updatePharma(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                  @RequestBody @Validated CreateOrUpdatePharmaDTO validator) {
        PharmaDO pharma = pharmaService.getById(id);
        if (pharma == null) {
            throw new NotFoundException(10022); // 可以根据需要修改异常代码
        }
        pharmaService.updatePharma(pharma, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的医药公司记录
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除医药公司", module = "医药公司管理")
    public DeletedVO deletePharma(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        PharmaDO pharma = pharmaService.getById(id);
        if (pharma == null) {
            throw new NotFoundException(10022); // 可以根据需要修改异常代码
        }
        pharmaService.deleteById(pharma.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
