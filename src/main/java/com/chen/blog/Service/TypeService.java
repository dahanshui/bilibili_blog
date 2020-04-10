package com.chen.blog.Service;

import com.chen.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TypeService {

    Type getType(Long id);
    Page<Type> listType(Pageable pageable);
    Type saveType(Type type);
    Type updateType(Long id,Type type);
    void deleteType(Long id);
    Type findByName(String name);
    List<Type> listType();
    List<Type> listTypeTop(Integer size);
}
