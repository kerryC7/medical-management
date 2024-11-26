package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 必备材料数据对象
 */
@Data
@TableName("materials")
@EqualsAndHashCode(callSuper = true)
public class MaterialDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private Date createdAt;

    private Date updatedAt;
}
