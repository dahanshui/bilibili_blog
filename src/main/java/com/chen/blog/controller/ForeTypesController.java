package com.chen.blog.controller;

import com.chen.blog.Service.BlogService;
import com.chen.blog.Service.TypeService;
import com.chen.blog.dao.TypeRepository;
import com.chen.blog.pojo.Blog;
import com.chen.blog.pojo.Type;
import com.chen.blog.query.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ForeTypesController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 8,sort = "updateDate",direction = Sort.Direction.DESC) Pageable pageable
                        ,@PathVariable long id, Model model){
        List<Type> types = typeService.listTypeTop(10000);
        if ( id==-1 ){
            id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        Page<Blog> blogs = blogService.listBlog(pageable, blogQuery);
        model.addAttribute("types",types);
        model.addAttribute("blogs",blogs);
        model.addAttribute("activeId",id);
        model.addAttribute("page",blogs);
        return "types";
    }
}
