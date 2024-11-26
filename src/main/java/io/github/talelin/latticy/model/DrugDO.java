package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 药品数据对象
 */
@Data
@TableName("drugs")
@NoArgsConstructor
public class DrugDO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Date createdAt;
    private Date updatedAt;
}
