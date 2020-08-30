package com.sikiedu.springbootssmeasylogin.controller;


import com.sikiedu.springbootssmeasylogin.entity.User;
import com.sikiedu.springbootssmeasylogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(User user){
        System.out.println(user);

        boolean success = userService.findUserByUsernameAndPassword(user);
        if(success){

            return "login-success.html";

        }
        else{

           return "redirect:/";

        }


    }






    @RequestMapping("/register")
    public String register(User user, String repassword, Model model){

//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(repassword);
        //校验password以及repassword是否一致
        if(user.getPassword().equals(repassword))
        {
            //检验用户是否注册过
            boolean isRegister = userService.isRegister(user);
            if(!isRegister){
                model.addAttribute("error","该用户已经注册过了");
                return "error.html";
            }
           //一致

           boolean success = userService.save(user);
           if(success){
             model.addAttribute("error","注册成功");
             return "error.html";

           }
           else{
               model.addAttribute("error","注册失败");
               return "error.html";
           }

        }
        else{
            model.addAttribute("error","两次输入的密码不一致~");
            return "error.html";
        }

    }















}
