package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 城市数据对象
 */
@Data
@TableName("cities")
@EqualsAndHashCode(callSuper = true)
public class CityDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name; // 城市名称

    private String country; // 所属国家

    private LocalDateTime createdAt; // 创建时间

    private LocalDateTime updatedAt; // 更新时间
}
