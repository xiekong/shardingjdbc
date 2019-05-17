package com.xiekong.shardingjdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiekong.shardingjdbc.mapper.UserMapper;
import com.xiekong.shardingjdbc.model.User;
import com.xiekong.shardingjdbc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author XieKong
 * @date 2019/5/17 11:59
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public List<User> listUser() {
        // 强制路由主库
//        HintManager.getInstance().setMasterRouteOnly();
        return list();
    }

    @Override
    public boolean addUser() {
        int random = new Random().nextInt(10);
        return save(new User().setName("cs" + random).setNickName("xiekong" + random));
    }
}
