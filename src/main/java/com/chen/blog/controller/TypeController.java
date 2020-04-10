package com.chen.blog.controller;

import com.chen.blog.Service.TypeService;
import com.chen.blog.pojo.Type;
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
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public String typePage(@PageableDefault(size = 8,sort = "id",direction = Sort.Direction.DESC)
                                       Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String addType(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        Type byName = typeService.findByName(type.getName());
        if ( byName!=null ){
            result.rejectValue("name","nameError","不能添加重复分类");
        }
        if ( result.hasErrors() ){
            return "admin/types-input";
        }
        Type t = typeService.saveType(type);
        if ( t==null ){
           attributes.addFlashAttribute("message","增加失败");
        }else {
            attributes.addFlashAttribute("message","增加成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/input")
    public String editType(@PathVariable Long id,Model model){
        Type type = typeService.getType(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }
    @PostMapping("/types/{id}")
    public String updateType(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes){
        Type byName = typeService.findByName(type.getName());
        if ( byName!=null ){
            result.rejectValue("name","nameError1","不能添加重复分类");
        }
        if ( result.hasErrors() ){
            return "admin/types-input";
        }
        Type t = typeService.updateType(id, type);
        if ( t==null ){
            attributes.addFlashAttribute("message","更新失败");
        }else {
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }


}