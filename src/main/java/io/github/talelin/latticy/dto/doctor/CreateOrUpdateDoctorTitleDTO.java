package io.github.talelin.latticy.dto.doctor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * 职称创建/更新数据传输对象
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateDoctorTitleDTO {

    @NotEmpty(message = "{doctor.title.not-empty}")
    @Length(max = 255, message = "{doctor.title.length}")
    private String titleName;  // 职称名称

    @Length(max = 1000, message = "{doctor.title.description.length}")
    private String description;  // 职称描述

    @NotNull(message = "{doctorTitle.numberOfDoctors.not-null}")
    @Positive(message = "{doctorTitle.numberOfDoctors.positive}")
    private Integer numberOfDoctors; // 医师数量

}
