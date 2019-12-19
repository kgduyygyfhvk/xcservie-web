package xyz.xcservice.www.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wuwenchao
 * @create 2019/12/17
 **/
@Data
public class ResultRequest implements Serializable {

    private String traceLogId;

    private String systemName;
}
