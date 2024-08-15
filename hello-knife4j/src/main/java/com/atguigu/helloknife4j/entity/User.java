package com.atguigu.helloknife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户实体信息")
public class User {
    @Schema(description = "用户Id")
    private Integer id;
    @Schema(description = "用户姓名")
    private  String name;
    @Schema(description = "用户年龄  ")
    private  Integer age;

}
