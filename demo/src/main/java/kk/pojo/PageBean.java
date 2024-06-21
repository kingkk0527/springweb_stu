package kk.pojo;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @ PageBean : 分页查询结果封装类
 * @ Description:
 */

@Data
@NoAutoStart
@AllArgsConstructor
public class PageBean {

    private Long total;//总记录数
    private List rows;//数据列表
}
