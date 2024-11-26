package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.doctor.CreateOrUpdateDoctorDTO;
import io.github.talelin.latticy.model.DoctorDO;
import io.github.talelin.latticy.service.DoctorService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 医师控制器
 */
@RestController
@RequestMapping("/v1/doctor")
@Validated
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * 获取指定ID的医师信息
     */
    @GetMapping("/{id}")
    public DoctorDO getDoctor(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        DoctorDO doctor = doctorService.getById(id);
        if (doctor == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return doctor;
    }

    /**
     * 获取所有医师信息
     */
    @GetMapping("")
    public List<DoctorDO> getDoctors() {
        return doctorService.findAll();
    }

    /**
     * 根据关键字查询医师信息
     */
    @GetMapping("/search")
    public List<DoctorDO> searchDoctor(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return doctorService.getDoctorByKeyword("%" + q + "%");
    }

    /**
     * 创建新的医师记录
     */
    @PostMapping("")
    public CreatedVO createDoctor(@RequestBody @Validated CreateOrUpdateDoctorDTO validator) {
        doctorService.createDoctor(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的医师信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updateDoctor(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                  @RequestBody @Validated CreateOrUpdateDoctorDTO validator) {
        DoctorDO doctor = doctorService.getById(id);
        if (doctor == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        doctorService.updateDoctor(doctor, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的医师记录
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除医师", module = "医师管理")
    public DeletedVO deleteDoctor(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        DoctorDO doctor = doctorService.getById(id);
        if (doctor == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        doctorService.deleteById(doctor.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
