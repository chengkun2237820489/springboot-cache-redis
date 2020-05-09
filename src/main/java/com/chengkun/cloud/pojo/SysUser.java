package com.chengkun.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2019/4/27.
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {

    private Integer id;
    private String name;
    private Integer age;
}
