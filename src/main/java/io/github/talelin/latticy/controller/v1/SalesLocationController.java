package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.saleslocation.CreateOrUpdateSalesLocationDTO;
import io.github.talelin.latticy.model.SalesLocationDO;
import io.github.talelin.latticy.service.SalesLocationService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 销售地点控制器
 */
@RestController
@RequestMapping("/v1/sales_location")
@Validated
public class SalesLocationController {

    @Autowired
    private SalesLocationService salesLocationService;

    /**
     * 获取指定 ID 的销售地点信息
     */
    @GetMapping("/{id}")
    public SalesLocationDO getSalesLocation(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        SalesLocationDO salesLocation = salesLocationService.getById(id);
        if (salesLocation == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return salesLocation;
    }

    /**
     * 获取所有销售地点信息
     */
    @GetMapping("")
    public List<SalesLocationDO> getSalesLocations() {
        return salesLocationService.findAll();
    }

    /**
     * 根据关键字查询销售地点信息
     */
    @GetMapping("/search")
    public List<SalesLocationDO> searchSalesLocation(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return salesLocationService.getSalesLocationByKeyword("%" + q + "%");
    }

    /**
     * 创建新的销售地点
     */
    @PostMapping("")
    public CreatedVO createSalesLocation(@RequestBody @Validated CreateOrUpdateSalesLocationDTO validator) {
        salesLocationService.createSalesLocation(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定 ID 的销售地点信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updateSalesLocation(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                         @RequestBody @Validated CreateOrUpdateSalesLocationDTO validator) {
        SalesLocationDO salesLocation = salesLocationService.getById(id);
        if (salesLocation == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        salesLocationService.updateSalesLocation(salesLocation, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定 ID 的销售地点
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除销售地点", module = "销售地点管理")
    public DeletedVO deleteSalesLocation(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        SalesLocationDO salesLocation = salesLocationService.getById(id);
        if (salesLocation == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        salesLocationService.deleteById(salesLocation.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
