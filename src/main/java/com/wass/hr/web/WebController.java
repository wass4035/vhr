package com.wass.hr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @RequestMapping("/index")
    @ResponseBody
    public String getWeb(){
        System.out.println("------------------------");
        return "redirect:/index.jsp";
    }
}
