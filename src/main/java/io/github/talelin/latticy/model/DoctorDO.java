package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sdu_cml
 * 医师数据对象
 */
@Data
@TableName("doctor")
@EqualsAndHashCode(callSuper = true)
public class DoctorDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医师姓名
     */
    private String name;

    /**
     * 职称，如主任医师、主治医师等
     */
    private String title;

    /**
     * 所在医院
     */
    private String hospital;

    /**
     * 所在科室
     */
    private String department;

    /**
     * 医生的联系方式
     */
    private String phone;

    /**
     * 医生的简介（可以填写医疗专长等）
     */
    private String summary;

    /**
     * 医生头像的图片路径
     */
    private String image;
}
