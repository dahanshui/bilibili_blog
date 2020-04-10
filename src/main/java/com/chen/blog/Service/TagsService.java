package com.chen.blog.Service;

import com.chen.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagsService {

    Tag saveTag(Tag tag);
    void deleteTag(Long id);
    Tag updateTag(Long id,Tag tag);
    Tag getTag(Long id);
    Page<Tag> listTags(Pageable pageable);
    Tag findByName(String name);
    List<Tag> listTags();
    List<Tag> listTagsTop(Integer size);
    List<Tag> listTags(String ids);

}
