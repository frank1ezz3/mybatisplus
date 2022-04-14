package com.example.mybatisplus;

import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        //查询总记录数
        long count = userService.count();//SELECT COUNT( * ) FROM user
        System.out.println("总记录数："+count);//Row: 5
    }

    //批量添加数据，Service专有的
    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("ybc"+i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);//INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        System.out.println(b);
    }
}
