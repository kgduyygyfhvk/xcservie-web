package xyz.xcservice.www.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author wuwenchao
 * @create 2019/11/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntity extends ResultRequest {

    private static final long serialVersionUID = -5211466388436752649L;

    private Long id;

    private LocalDateTime createAt;

    private String createBy;

    private LocalDateTime updateAt;

    private String updateBy;
}
