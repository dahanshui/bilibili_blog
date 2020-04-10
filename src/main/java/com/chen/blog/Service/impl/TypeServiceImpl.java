package com.chen.blog.Service.impl;

import com.chen.blog.Service.TypeService;
import com.chen.blog.dao.TypeRepository;
import com.chen.blog.exception.NotFoundException;
import com.chen.blog.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    TypeRepository typeRepository;

    @Transactional
    @Override
    public Type getType(Long id) {
        Type type = typeRepository.findById(id).get();
        return type;
    }
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        Page<Type> types =  typeRepository.findAll(pageable);
        return types;
    }
    @Transactional
    @Override
    public Type saveType(Type type) {
        Type save = typeRepository.save(type);
        return save;
    }
    @Transactional
    @Override
    public Type updateType(Long id,Type type) {
        Type t = typeRepository.findById(id).get();
        if ( t==null ){
            throw new NotFoundException("分类不存在");
        }else {
            BeanUtils.copyProperties(type,t);
            return typeRepository.save(t);
        }
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Type findByName(String name) {
        Type type = typeRepository.findByName(name);
        return type;
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return typeRepository.findTop(pageable);
    }
}
