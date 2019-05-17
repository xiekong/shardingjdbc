package com.xiekong.shardingjdbc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiekong.shardingjdbc.model.User;

import java.util.List;

/**
 * @author XieKong
 * @date 2019/5/17 11:59
 */
public interface UserService extends IService<User> {
    List<User> listUser();

    boolean addUser();
}
