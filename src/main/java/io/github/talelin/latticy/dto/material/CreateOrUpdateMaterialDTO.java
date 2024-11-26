package io.github.talelin.latticy.dto.material;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 必备材料创建/更新数据传输对象
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateMaterialDTO {

    @NotEmpty(message = "{material.name.not-empty}")
    @Size(max = 255, message = "{material.name.length}")
    private String name;

    @Size(max = 1000, message = "{material.description.length}")
    private String description;
}
