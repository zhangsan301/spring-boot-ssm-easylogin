package com.sikiedu.springbootssmeasylogin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //首页展示
    @RequestMapping("")
    public String mainIndex(){
        return "index.html";
    }

   @RequestMapping("/index")
   public String  index(){

       return "index.html";
   }










}
