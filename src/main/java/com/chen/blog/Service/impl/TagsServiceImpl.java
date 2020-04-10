package com.chen.blog.Service.impl;

import com.chen.blog.Service.TagsService;
import com.chen.blog.dao.TagsRepository;
import com.chen.blog.exception.NotFoundException;
import com.chen.blog.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    TagsRepository tagsRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagsRepository.save(tag);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagsRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagsRepository.getOne(id);
        if ( t!=null ){
            BeanUtils.copyProperties(tag,t);
        }else {
            throw new NotFoundException("标签不存在");
        }
        return tagsRepository.save(t);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        Tag tag = tagsRepository.getOne(id);
        return tag;
    }

    @Transactional
    @Override
    public Page<Tag> listTags(Pageable pageable) {
        Page<Tag> tags = tagsRepository.findAll(pageable);
        return tags;
    }

    @Transactional
    @Override
    public Tag findByName(String name) {
        return tagsRepository.findByName(name);
    }

    @Transactional
    @Override
    public List<Tag> listTags() {
        return tagsRepository.findAll();
    }

    @Override
    public List<Tag> listTagsTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagsRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public List<Tag> listTags(String ids) {
        List<Long> list = convertToList(ids);
        return tagsRepository.findAllById(list);
    }

    public List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if ( !"".equals(ids) && ids!=null ){
            String[] split = ids.split(",");
            for (int i = 0; i < split.length; i++) {
                list.add(new Long(split[i]));
            }
        }
        return list;
    }
}
