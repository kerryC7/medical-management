package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 科室数据对象
 */
@Data
@TableName("department")
@EqualsAndHashCode(callSuper = true)
public class DepartmentDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String departmentName;  // 科室名称

    private Integer numberOfStaff;  // 科室人数

    private String description;     // 科室描述
}
