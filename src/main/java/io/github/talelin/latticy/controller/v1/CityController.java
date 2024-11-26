package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.city.CreateOrUpdateCityDTO;
import io.github.talelin.latticy.model.CityDO;
import io.github.talelin.latticy.service.CityService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 城市控制器
 */
@RestController
@RequestMapping("/v1/city")
@Validated
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 获取指定ID的城市信息
     */
    @GetMapping("/{id}")
    public CityDO getCity(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        CityDO city = cityService.getById(id);
        if (city == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return city;
    }

    /**
     * 获取所有城市信息
     */
    @GetMapping("")
    public List<CityDO> getCities() {
        return cityService.findAll();
    }

    /**
     * 根据关键字查询城市信息
     */
    @GetMapping("/search")
    public List<CityDO> searchCity(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return cityService.getCityByKeyword("%" + q + "%");
    }

    /**
     * 创建新的城市记录
     */
    @PostMapping("")
    public CreatedVO createCity(@RequestBody @Validated CreateOrUpdateCityDTO validator) {
        cityService.createCity(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的城市信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updateCity(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                @RequestBody @Validated CreateOrUpdateCityDTO validator) {
        CityDO city = cityService.getById(id);
        if (city == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        cityService.updateCity(city, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的城市记录
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除城市", module = "城市管理")
    public DeletedVO deleteCity(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        CityDO city = cityService.getById(id);
        if (city == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        cityService.deleteById(city.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
