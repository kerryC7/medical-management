package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 职称表数据对象
 */
@Data
@NoArgsConstructor
@TableName("doctor_title")
public class DoctorTitleDO {

    @TableId
    private Integer id;

    private String titleName;  // 职称名称

    private Integer numberOfDoctors = 0;  // 拥有该职称的医师数量

    private String description;  // 职称描述

    private Date createdAt;  // 创建时间

    private Date updatedAt;  // 更新时间

}
