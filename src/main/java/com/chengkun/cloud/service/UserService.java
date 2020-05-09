package com.chengkun.cloud.service;

import com.chengkun.cloud.pojo.SysUser;

import java.util.List;

/**
 * sungrow all right reserved
 **/
public interface UserService {

    List<SysUser> queryUserList();

    SysUser save(SysUser user);

    SysUser findUserById(Integer id);

    SysUser updateUser(SysUser user);

    int deleteUser(Integer id);
}
