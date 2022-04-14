package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        //生成新增的用户信息
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setName("李佳豪");
        user.setAge(18);
        user.setEmail("lijiahao@qq.com");
        int result =  userMapper.insert(user);
        System.out.println("结果："+result);
        System.out.println("id:"+user.getId());//1513874858605539330//雪花算法生成ID
    }

    @Test
    public void testDelete(){
        //通过ID删除用户信息     DELETE FROM user WHERE id=?
        //Updates: 1
//        int result = userMapper.deleteById(1513874858605539330L);
//        System.out.println("result:"+result);


//        //根据map集合中所这是的条件删除用户信息
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","李佳豪");
//        map.put("age",18);
//        int result = userMapper.deleteByMap(map);//DELETE FROM user WHERE name = ? AND age = ?
//        System.out.println("result:"+result);//Updates: 0

        //通过多个id实现批量删除
        List<Long> LIST = Arrays.asList(1L, 2L, 3L);
        userMapper.deleteBatchIds(LIST);//DELETE FROM user WHERE id IN ( ? , ? , ? )
        System.out.println("result:"+LIST);//Updates: 3 //这里的是指定被删除的数据

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@atguigu.com");
        int result = userMapper.updateById(user);//UPDATE user SET name=?, email=? WHERE id=?
        System.out.println("result:"+result);//Updates: 1
    }

    @Test
    public void testSelect(){
        //通过ID查询用户信息
//        User user = userMapper.selectById(1L);//SELECT id,name,age,email FROM user WHERE id=?
//        System.out.println(user);//1, Jone, 18, test1@baomidou.com

        //根据多个ID查询多个用户信息
//        List<Long> list = Arrays.asList(1L, 2L, 3L);//SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//        List<User> users = userMapper.selectBatchIds(list);
//        users.forEach(System.out::println);
        //<==        Row: 1, Jone, 18, test1@baomidou.com
        //<==        Row: 2, Jack, 20, test2@baomidou.com
        //<==        Row: 3, Tom, 28, test3@baomidou.com

        //根据map集合中的条件查询用户信息
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","Jack");
//        map.put("age",20);//SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);//2, Jack, 20, test2@baomidou.com

        //查询所有数据
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);//SELECT id,name,age,email FROM user


    }

    @Test
    public void testConsumer() {
        Map<String, Object> map = userMapper.selectMapById(1L);//select id,name,age,email from user where id = ?
        System.out.println("map = " + map);//1, Jone, 18, test1@baomidou.com
    }
}
