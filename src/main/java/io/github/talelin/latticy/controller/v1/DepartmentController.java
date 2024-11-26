package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import io.github.talelin.latticy.dto.department.CreateOrUpdateDepartmentDTO;
import io.github.talelin.latticy.model.DepartmentDO;
import io.github.talelin.latticy.service.DepartmentService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * 科室控制器
 */
@RestController
@RequestMapping("/v1/department")
@Validated
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取指定ID的科室信息
     */
    @GetMapping("/{id}")
    public DepartmentDO getDepartment(@PathVariable(value = "id") @Positive(message = "{id.positive}") Integer id) {
        DepartmentDO department = departmentService.getById(id);
        if (department == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        return department;
    }

    /**
     * 获取所有科室信息
     */
    @GetMapping("")
    public List<DepartmentDO> getDepartments() {
        return departmentService.findAll();
    }

    /**
     * 根据关键字查询科室信息
     */
    @GetMapping("/search")
    public List<DepartmentDO> searchDepartment(@RequestParam(value = "q", required = false, defaultValue = "") String q) {
        return departmentService.getDepartmentByKeyword("%" + q + "%");
    }

    /**
     * 创建新的科室记录
     */
    @PostMapping("")
    public CreatedVO createDepartment(@RequestBody @Validated CreateOrUpdateDepartmentDTO validator) {
        departmentService.createDepartment(validator);
        return new CreatedVO(12); // 返回创建成功的响应
    }

    /**
     * 更新指定ID的科室信息
     */
    @PutMapping("/{id}")
    public UpdatedVO updateDepartment(@PathVariable("id") @Positive(message = "{id.positive}") Integer id,
                                      @RequestBody @Validated CreateOrUpdateDepartmentDTO validator) {
        DepartmentDO department = departmentService.getById(id);
        if (department == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        departmentService.updateDepartment(department, validator);
        return new UpdatedVO(13); // 返回更新成功的响应
    }

    /**
     * 删除指定ID的科室记录
     */
    @DeleteMapping("/{id}")
    @GroupRequired
    @PermissionMeta(value = "删除科室", module = "科室管理")
    public DeletedVO deleteDepartment(@PathVariable("id") @Positive(message = "{id.positive}") Integer id) {
        DepartmentDO department = departmentService.getById(id);
        if (department == null) {
            throw new NotFoundException(10022); // 这里可以修改为更符合业务的异常代码
        }
        departmentService.deleteById(department.getId());
        return new DeletedVO(14); // 返回删除成功的响应
    }
}
