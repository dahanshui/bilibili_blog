package com.chen.blog.Service;

import com.chen.blog.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findCommentByBlogId(Long blogId);
    Comment saveComment(Comment comment);
    List<Comment> eachComment(List<Comment> comments);
    void combineChildren(List<Comment> comments);
    void recursively(Comment comment);

}
