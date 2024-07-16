package kk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ DeptLog :
 * @ Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptLog {
    private int id;
    private LocalDateTime createTime;
    private String description;

}
