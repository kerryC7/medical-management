package io.github.talelin.latticy.dto.doctor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 医师创建/更新数据传输对象
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateDoctorDTO {

    @NotEmpty(message = "{doctor.name.not-empty}")
    @Length(max = 100, message = "{doctor.name.length}")
    private String name;

    @Length(max = 50, message = "{doctor.title.length}")
    private String title; // 医生职称

    @Length(max = 255, message = "{doctor.hospital.length}")
    private String hospital; // 医院名称

    @Length(max = 255, message = "{doctor.department.length}")
    private String department; // 科室名称

    @Length(max = 20, message = "{doctor.phone.length}")
    private String phone; // 医生电话

    @Length(max = 1000, message = "{doctor.summary.length}")
    private String summary; // 医生简介

    @Length(max = 255, message = "{doctor.image.length}")
    private String image; // 医生头像

    @NotNull(message = "{doctor.createTime.not-null}")
    private String createTime; // 创建时间

    @NotNull(message = "{doctor.updateTime.not-null}")
    private String updateTime; // 更新时间
}
