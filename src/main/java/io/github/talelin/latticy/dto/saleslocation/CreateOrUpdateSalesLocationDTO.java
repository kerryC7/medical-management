package io.github.talelin.latticy.dto.saleslocation;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * 销售地点创建/更新数据传输对象
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateSalesLocationDTO {

    @NotEmpty(message = "{saleslocation.name.not-empty}")
    @Length(max = 255, message = "{saleslocation.name.length}")
    private String name;  // 销售地点名称

    @Length(max = 255, message = "{saleslocation.address.length}")
    private String address;  // 销售地点地址
}
