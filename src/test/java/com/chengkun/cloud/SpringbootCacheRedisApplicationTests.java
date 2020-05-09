package com.chengkun.cloud;

import com.alibaba.druid.pool.DruidDataSource;
import com.chengkun.cloud.mapper.UserMapper;
import com.chengkun.cloud.pojo.SysUser;
import com.chengkun.cloud.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootCacheRedisApplicationTests {

    @Resource
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;


    @Test
    void contextLoads() throws SQLException {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        connection.close();

    }

    /**
     * @Description 测试mybatis
     * @Author chengkun
     * @Date 2020/4/29 10:39
     * @Param
     * @Return void
     **/
    @Test
    void test1() {
        List<SysUser> sysUsers = userMapper.queryUserList();
        System.out.println(sysUsers);
    }

    /**
     * @Description 测试redis工具类
     * @Author chengkun
     * @Date 2020/4/29 11:25
     * @Param
     * @Return void
     **/
    @Test
    void test2() {
        Set<String> keys = redisUtil.keys("*");
        System.out.println(keys);
        Map<Object, Object> hgetall = redisUtil.hgetall("1000");
        System.out.println(hgetall);
        redisUtil.setDataBase(2);
        Map<Object, Object> hgetall1 = redisUtil.hgetall("10.10.10.41");
        System.out.println(hgetall1);
    }

}
