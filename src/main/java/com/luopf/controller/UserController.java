package com.luopf.controller;

import com.luopf.dto.User;
import com.luopf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/14 9:50
 * @Version 1.0
 **/
@Controller  //声明为控制器
@RequestMapping(path = "/user")  //请求映射
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/index")  //请求映射
    public String index(Model model){
        model.addAttribute("list",userService.queryAllUsers());
        return "user/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/user/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user){
        userService.addUser(user);
        return "redirect:/user/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "user/edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(User user){
        userService.editUser(user);
        return "redirect:/user/index";
    }

}
