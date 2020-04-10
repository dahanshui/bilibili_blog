package com.chen.blog.controller;


import com.chen.blog.Service.BlogService;
import com.chen.blog.Service.TagsService;
import com.chen.blog.Service.TypeService;
import com.chen.blog.pojo.Blog;
import com.chen.blog.pojo.Type;
import com.chen.blog.pojo.User;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT="admin/blogs-input";
    private static final String LIST="admin/blogs";
    private static final String REDIRECT_LIST="redirect:/admin/blogs";


    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagsService tagsService;

    @GetMapping("/blogs")
    public String blogsPage(@PageableDefault(size = 8,sort = "updateDate",direction = Sort.Direction.DESC) Pageable pageable,
                            BlogQuery blog, Model model){
        List<Type> types = typeService.listType();
        Page<Blog> blogs = blogService.listBlog(pageable, blog);
        model.addAttribute("page",blogs);
        model.addAttribute("types",types);
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 8,sort = "updateDate",direction = Sort.Direction.DESC) Pageable pageable,
                            BlogQuery blog, Model model){
        Page<Blog> blogs = blogService.listBlog(pageable, blog);
        model.addAttribute("page",blogs);
        return "admin/blogs::blogList";
    }

    @GetMapping("/blogs/input")
    public String inputPage(Model model){
        initTypeAndTag(model);
        model.addAttribute("blog",new Blog());
        return INPUT;
    }

    private void initTypeAndTag(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagsService.listTags());
    }

    @GetMapping("/blogs/{id}/input")
    public String editPage(@PathVariable Long id, Model model){
        initTypeAndTag(model);
        Blog blog = blogService.getBlog(id);
        blog.init();
        model.addAttribute("blog",blog);
        return INPUT;
    }
    @PostMapping("/blogs")
    public String input(Blog blog, HttpSession session, RedirectAttributes attributes){
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagsService.listTags(blog.getTagIds()));
        Blog saveBlog;
        if ( blog.getId()==null ){
            saveBlog = blogService.saveBlog(blog);
        }else {
            saveBlog = blogService.updateBlog(blog.getId(),blog);
        }
        if ( saveBlog==null ){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return REDIRECT_LIST;
    }


    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return REDIRECT_LIST;
    }


}
