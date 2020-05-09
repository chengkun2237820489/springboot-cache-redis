package com.chengkun.cloud.mapper;

import com.chengkun.cloud.pojo.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chengkun
 * @version v1.0
 * @create 2019/10/6 16:08
 **/
@Mapper
@Component
public interface UserMapper {
    List<SysUser> queryUserList();

    SysUser findUserById(Integer id);

    int updateUser(SysUser user);

    int saveUser(SysUser user);

    int deleteUser(Integer id);
}
