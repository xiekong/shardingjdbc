package com.xiekong.shardingjdbc.controller;

import com.xiekong.shardingjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XieKong
 * @date 2019/5/17 12:56
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public Object list() {
        return userService.listUser();
    }

    @PostMapping("/add")
    public Object add() {
        return userService.addUser();
    }
}
