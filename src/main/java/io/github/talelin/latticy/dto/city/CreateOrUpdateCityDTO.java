package io.github.talelin.latticy.dto.city;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 城市创建/更新数据传输对象
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateCityDTO {

    @NotEmpty(message = "{city.name.not-empty}")
    @Size(max = 255, message = "{city.name.length}")
    private String name; // 城市名称

    @Size(max = 255, message = "{city.country.length}")
    private String country; // 所属国家
}
