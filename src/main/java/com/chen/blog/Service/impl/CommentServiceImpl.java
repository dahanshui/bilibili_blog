package com.chen.blog.Service.impl;

import com.chen.blog.Service.CommentService;
import com.chen.blog.dao.CommentRepository;
import com.chen.blog.pojo.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findCommentByBlogId(Long blogId) {
        Sort s = Sort.by( "createDate");
        List<Comment> comments = commentRepository.findByBlogIdAndCommentNull(blogId,s);
        return eachComment(comments);
    }

    @Transactional
    @Override
    public List<Comment> eachComment(List<Comment> comments) {
        List<Comment> newComments = new ArrayList<>();
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment, c);
            newComments.add(c);
        }
        combineChildren(newComments);
        return newComments;
    }

    @Transactional
    @Override
    public void combineChildren(List<Comment> comments) {
        for (Comment comment : comments) {
            List<Comment> replyComments = comment.getReplyComments();
            if (replyComments.size() > 0) {
                for (Comment replyComment : replyComments) {
                    recursively(replyComment);
                }
                comment.setReplyComments(commentReplys);
                commentReplys = new ArrayList<>();
            }
        }
    }

    private List<Comment> commentReplys = new ArrayList<>();

    @Transactional
    @Override
    public void recursively(Comment comment) {
        commentReplys.add(comment);
        List<Comment> replyComments = comment.getReplyComments();
        if ( replyComments.size()>0 ){
            for (Comment replyComment : replyComments) {
                if (replyComment.getReplyComments().size() > 0) {
                    recursively(replyComment);
                }else {
                    commentReplys.add(replyComment);
                }
            }
        }
    }

    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getComment().getId();
        if (parentCommentId != -1) {
            comment.setComment(commentRepository.findById(parentCommentId).get());
        } else {
            comment.setComment(null);
        }
        comment.setCreateDate(new Date());
        return commentRepository.save(comment);
    }
}
