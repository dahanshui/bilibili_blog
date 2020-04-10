package com.chen.blog.controller;

import com.chen.blog.Service.BlogService;
import com.chen.blog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForeArchivesController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("blogCount",blogService.blogCount());
        model.addAttribute("archivesMap",blogService.listBlogByYear());
        return "archives";
    }
}
