package io.github.talelin.latticy.dto.policy;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 创建或更新政策信息DTO
 */
@Data
public class CreateOrUpdatePolicyDTO {

    @NotBlank(message = "政策标题不能为空")
    private String policyTitle;          // 政策标题

    private String policyDescription;    // 政策内容

    private String policyType;           // 政策类型

    @NotNull(message = "发布日期不能为空")
    private LocalDateTime releaseDate;   // 政策发布日期
}
