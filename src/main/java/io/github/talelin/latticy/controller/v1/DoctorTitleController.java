package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.doctor.CreateOrUpdateDoctorTitleDTO;
import io.github.talelin.latticy.model.DoctorTitleDO;
import io.github.talelin.latticy.service.DoctorTitleService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 职称管理控制器
 */
@RestController
@RequestMapping("/v1/doctor-title")
@Validated
public class DoctorTitleController {

    @Autowired
    private DoctorTitleService doctorTitleService;

    /**
     * 获取指定ID的职称信息
     */
    @GetMapping("/{id}")
    public DoctorTitleDO getDoctorTitle(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        DoctorTitleDO doctorTitle = doctorTitleService.getById(id);
        if (doctorTitle == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return doctorTitle;
    }

    /**
     * 获取所有职称信息
     */
    @GetMapping("")
    public List<DoctorTitleDO> getDoctorTitles() {
        return doctorTitleService.findAll();
    }

    /**
     * 根据关键字查询职称信息
     */
    @GetMapping("/search")
    public List<DoctorTitleDO> searchDoctorTitle(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return doctorTitleService.getDoctorTitleByTitleName("%" + q + "%");
    }

    /**
     * 创建新的职称记录
     */
    @PostMapping("")
    public CreatedVO createDoctorTitle(@RequestBody @Validated CreateOrUpdateDoctorTitleDTO validator) {
        doctorTitleService.createDoctorTitle(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的职称信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updateDoctorTitle(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                       @RequestBody @Validated CreateOrUpdateDoctorTitleDTO validator) {
        DoctorTitleDO doctorTitle = doctorTitleService.getById(id);
        if (doctorTitle == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        doctorTitleService.updateDoctorTitle(doctorTitle, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的职称记录
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除职称", module = "职称管理")
    public DeletedVO deleteDoctorTitle(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        DoctorTitleDO doctorTitle = doctorTitleService.getById(id);
        if (doctorTitle == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        doctorTitleService.deleteById(doctorTitle.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
