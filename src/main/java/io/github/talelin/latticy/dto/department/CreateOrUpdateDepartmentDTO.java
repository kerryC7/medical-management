package io.github.talelin.latticy.dto.department;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 创建或更新科室信息 DTO
 */
@Data
public class CreateOrUpdateDepartmentDTO {

    @NotEmpty(message = "科室名称不能为空")
    private String departmentName;

    @NotNull(message = "科室人数不能为空")
    private Integer numberOfStaff;

    private String description;
}
