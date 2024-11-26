package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 销售地点数据对象
 */
@Data
@TableName("sales_locations")
@EqualsAndHashCode(callSuper = true)
public class SalesLocationDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1234567890L;

    private String name;  // 销售地点名称
    private String address;  // 销售地点地址
}
