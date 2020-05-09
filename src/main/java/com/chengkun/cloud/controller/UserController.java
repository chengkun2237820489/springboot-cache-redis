package com.chengkun.cloud.controller;

import com.chengkun.cloud.pojo.SysUser;
import com.chengkun.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:Administrator
 * @date:2019/10/6
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/list")
    public List<SysUser> get() {
        return userService.queryUserList();
    }

    @GetMapping("/user/save")
    public SysUser saveUser(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age){
        SysUser user= userService.save(new SysUser(id,name,age));
        return user;
    }

    @GetMapping("/user/{id}")
    public SysUser getUserById(@PathVariable Integer id){

        System.out.println("id="+id);
        SysUser user = userService.findUserById(id);

        System.out.println("getUserById - "+user);
        return user;
    }

    @GetMapping("/user/update")
    public SysUser updateUser(@RequestParam Integer id,@RequestParam String name,@RequestParam Integer age){
        SysUser user= userService.updateUser(new SysUser(id,name,age));
        return user;
    }

    @GetMapping("/user/del/{id}")
    public String deleteUser(@PathVariable Integer id){
        System.out.println("id="+id);
        int num = userService.deleteUser(id);
        if (num > 0){
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

}
