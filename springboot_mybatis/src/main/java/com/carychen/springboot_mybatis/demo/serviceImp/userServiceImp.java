package com.carychen.springboot_mybatis.demo.serviceImp;

import com.carychen.springboot_mybatis.demo.dao.user_infoMapper;
import com.carychen.springboot_mybatis.demo.entity.user_info;
import com.carychen.springboot_mybatis.demo.service.user_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImp implements user_service {

    @Autowired
    private user_infoMapper userInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int saveUser_info(user_info user) {
        return userInfoMapper.saveUserInfo(user);
    }

    @Override
    public int UpUser_info(user_info user) {
        return userInfoMapper.upUserInfo(user);
    }

    @Override
    public int delUser_info(int user_id) {
        return 0;
    }

    @Override
    public user_info getUserInfoById(String user_long, String user_paw) {
        user_info user_info = userInfoMapper.login(user_long, user_paw);
        ValueOperations<String, user_info> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey("user_info");
        return user_info;
    }

    @Override
    public List<user_info> getUserInfoAll(String name, int sys_id, int org_id,int page,int limit) {
        return userInfoMapper.getUserInfoAll(name,sys_id,org_id,page,limit);
    }

    @Override
    public int getUserCount(String name, int sys_id, int org_id) {
        return userInfoMapper.getUserCount(name,sys_id,org_id);
    }
}
