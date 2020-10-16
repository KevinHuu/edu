package com.atguigu.mpdemo;

import com.atguigu.mpdemo.entity.User;
import com.atguigu.mpdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectUser() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);

    }

    @Test
    void updateUser(){
        User user1 = userMapper.selectById(1316628984175316994l);
        user1.setAge(39);
        userMapper.updateById(user1);
    }

    @Test
    void addUser(){
        User user = new User();
        user.setName("Alice");
        user.setAge(30);
        int insert = userMapper.insert(user);

    }

    @Test
    void testPageSelect(){
        Page<User> page = new Page<>(1,3);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage.getRecords());
    }

    @Test
    void testDelete(){
        userMapper.deleteById(2l);
    }

    @Test
    void testWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        QueryWrapper<User> select = wrapper.select("id", "name");
        System.out.println(userMapper.selectList(select));
    }
}
