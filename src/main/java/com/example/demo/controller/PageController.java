package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/page")
public class PageController {

    //ModelandView 와 Model로 호출
    @GetMapping("/main")
    public ModelAndView mainpage(ModelAndView model){
        model.addObject("name", "ModelView!");
        model.setViewName("mainpage");
        return model;
    }
    @GetMapping("/main2")
    public String mainpage(Model model) {
        model.addAttribute("name", "Model!");
        return "mainpage";
    }
    //큰 차이는 없다 용도에 따라 사용

    @RequestMapping("customerInsert")
    public String customerInsert(){
        return "customerInsertPage";
    }

    @RequestMapping("customerFind")
    public String customerFind(){
        return "customerFind";
    }
}
