package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 政策信息数据对象
 */
@Data
@TableName("policy")
@EqualsAndHashCode(callSuper = true)
public class PolicyDO extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String policyTitle;          // 政策标题
    private String policyDescription;    // 政策内容
    private String policyType;           // 政策类型
    private LocalDateTime releaseDate;   // 政策发布日期
    private LocalDateTime updatedAt;     // 更新时间
}
