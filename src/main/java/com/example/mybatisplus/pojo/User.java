package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
@Data
//@TableName("user")
public class User {

    //@Table注解的value属性用于指定主键的字段
    @TableId(/*value = "id" , type = IdType.ASSIGN_ID*/)//将这个属性对应的字段作为主键,雪花算法生成ID
    private Long id;

    //指定属性所对应的字段名
    @TableField("name")
    private String name;//myplus中有默认的配置，把下划线默认为驼峰

    private Integer age;

    private String email;

    @TableLogic//   ”逻辑删除数据“，   防止删库跑路恢复数据，实际上这些数据还存在
    private Integer isDeleted;
}
