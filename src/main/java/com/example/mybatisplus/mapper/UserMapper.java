package com.example.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserMapper extends BaseMapper<User> {//由mybatis-plus提供的

    /** 根据id查询用户信息为map集合 **/
    Map<String,Object> selectMapById(Long id);

}
