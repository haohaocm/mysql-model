package org.example.mysqlmodel.Entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user") // 对应数据库表名
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
