package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Other on 2018/1/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userMapper.insert(user);
    }

    @RequestMapping(value = "/users/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        System.out.print("here");
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.findUsers(pageNum,pageSize);
    }
    @RequestMapping(value = "/saybye")
    public Object saybye(Model model){
        model.addAttribute("c","bye bye");
        System.out.print("here");
        return "/demo";
    }
}
