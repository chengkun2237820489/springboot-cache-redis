package com.chengkun.cloud.service.impl;
/**
 * sungrow all right reserved
 **/

import com.chengkun.cloud.mapper.UserMapper;
import com.chengkun.cloud.pojo.SysUser;
import com.chengkun.cloud.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户接口
 * @Author chengkun
 * @Date 2020/5/9 12:01
 **/
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "user", key = "#root.methodName") //保存的key为改方法名称
    @Override
    public List<SysUser> queryUserList() {
        //首次查询数据库
        System.out.println("查询数据库");
        return userMapper.queryUserList();
    }

    @Cacheable(value = "user", key = "#user.id")
    @Override
    public SysUser save(SysUser user) {
        int saveNum = userMapper.saveUser(user);
        System.out.println("saveNum=" + saveNum);
        return user;
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public SysUser findUserById(Integer id) {
        log.info("进入findUserById方法");
        return userMapper.findUserById(id);
    }

    @CachePut(value = "user", key = "#user.id")
    @Override
    public SysUser updateUser(SysUser user) {
        int num = userMapper.updateUser(user);
        System.out.println("num=" + num);
        return user;
    }

    @CacheEvict(value = "user", key = "#root.args[0]") //删除key为入参第一个的缓存
    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
}