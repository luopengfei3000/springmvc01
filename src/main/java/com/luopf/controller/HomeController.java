package com.luopf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 17:52
 * @Version 1.0
 **/
@Controller
@RequestMapping(path="/home")
public class HomeController {

    @RequestMapping(path = "/index")  //请求映射
    public String index(Model model){
        model.addAttribute("message","Hello Spring MVC!");
        return "home/index";
    }
}
