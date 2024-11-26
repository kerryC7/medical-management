package io.github.talelin.latticy.dto.pharma;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 创建/更新医药公司DTO
 */
@Data
@NoArgsConstructor
public class CreateOrUpdatePharmaDTO {

    @NotEmpty(message = "{pharma.name.not-empty}")
    @Length(max = 255, message = "{pharma.name.length}")
    private String name; // 医药公司名称

    @Length(max = 255, message = "{pharma.address.length}")
    private String address; // 医药公司地址

    @Pattern(regexp = "^\\+?[0-9\\-]*$", message = "{pharma.phone.invalid}")
    @Length(max = 50, message = "{pharma.phone.length}")
    private String phone; // 医药公司电话

    @Email(message = "{pharma.email.invalid}")
    @Length(max = 255, message = "{pharma.email.length}")
    private String email; // 医药公司邮箱

    @Length(max = 1000, message = "{pharma.policy.length}")
    private String policy; // 医药公司政策信息
}
