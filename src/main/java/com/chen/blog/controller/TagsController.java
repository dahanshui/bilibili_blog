package com.chen.blog.controller;

import com.chen.blog.Service.TagsService;
import com.chen.blog.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    TagsService tagsService;

    @GetMapping("/tags")
    public String tagsPage(@PageableDefault(size = 8,sort = "id",direction = Sort.Direction.DESC)
                               Pageable pageable, Model model){
        Page<Tag> tags = tagsService.listTags(pageable);
        model.addAttribute("tags",tags);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String saveTagPage(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }
    @PostMapping("/tags")
    public String saveTag(@Valid Tag tag, BindingResult result, Model model, RedirectAttributes attributes){
        Tag byName = tagsService.findByName(tag.getName());
        if (byName != null) {
            result.rejectValue("name","nameError","不能添加重复标签");
        }
        if ( result.hasErrors() ){
            return "admin/tags-input";
        }
        Tag saveTag = tagsService.saveTag(tag);
        if ( saveTag==null ){
            attributes.addFlashAttribute("message","增加失败");
        }else {
            attributes.addFlashAttribute("message","增加成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/input")
    public String editTag(@PathVariable Long id,Model model){
        Tag tag = tagsService.getTag(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    @PostMapping("/tags/{id}")
    public String saveTag(@Valid Tag tag, BindingResult result,@PathVariable Long id, Model model, RedirectAttributes attributes){
        Tag byName = tagsService.findByName(tag.getName());
        if (byName != null) {
            result.rejectValue("name","nameError1","不能添加重复标签");
        }
        if ( result.hasErrors() ){
            return "admin/tags-input";
        }
        Tag saveTag = tagsService.updateTag(id,tag);
        if ( saveTag==null ){
            attributes.addFlashAttribute("message","修改失败");
        }else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id,RedirectAttributes attributes){
        tagsService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}
