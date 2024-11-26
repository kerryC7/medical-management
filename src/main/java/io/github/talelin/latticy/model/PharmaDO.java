package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 医药公司数据对象
 */
@Data
@TableName("pharmas")
@EqualsAndHashCode(callSuper = true)
public class PharmaDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;         // 医药公司名称
    private String address;      // 地址
    private String phone;        // 电话
    private String email;        // 邮箱
    private String policy;       // 政策信息
    private String createdAt;    // 创建时间
    private String updatedAt;    // 更新时间
}
