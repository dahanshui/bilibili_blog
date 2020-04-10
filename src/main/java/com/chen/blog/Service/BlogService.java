package com.chen.blog.Service;

import com.chen.blog.pojo.Blog;
import com.chen.blog.query.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog saveBlog(Blog blog);
    void deleteBlog(Long id);
    Blog updateBlog(Long id,Blog blog);
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable, String query);
    Page<Blog> listBlogByTagId(Pageable pageable, Long tagId);
    Map<String,List<Blog>> listBlogByYear();
    Page<Blog> listBlog(Pageable pageable);
    Blog getAndConvert(Long id);
    long blogCount();
    List<Blog> listRecommendBlogTop(Integer size);


}
