package io.github.talelin.latticy.dto.drug;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * 药品创建/更新数据传输对象
 */
@Data
@NoArgsConstructor
public class CreateOrUpdateDrugDTO {

    @NotEmpty(message = "{drug.name.not-empty}")
    @Length(max = 255, message = "{drug.name.length}")
    private String name;

    @Length(max = 1000, message = "{drug.description.length}")
    private String description;

    @NotNull(message = "{drug.price.not-null}")
    @PositiveOrZero(message = "{drug.price.positive}")
    private BigDecimal price;
}
