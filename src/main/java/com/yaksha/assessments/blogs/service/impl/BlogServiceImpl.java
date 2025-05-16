package com.yaksha.assessments.blogs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaksha.assessments.blogs.entity.BlogEntity;
import com.yaksha.assessments.blogs.repository.BlogRepository;
import com.yaksha.assessments.blogs.service.BlogService;
import com.yaksha.assessments.blogs.exception.ResourceNotFoundException;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogEntity createBlog(BlogEntity blogEntity) {
        return blogRepository.save(blogEntity);
    }

    @Override
    public BlogEntity getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
    }

    @Override
    public BlogEntity updateBlog(BlogEntity blogEntity) {
        BlogEntity existing = blogRepository.findById(blogEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        existing.setTitle(blogEntity.getTitle());
        existing.setContent(blogEntity.getContent());
        BlogEntity updated = blogRepository.save(existing);
        return updated;
    }

    @Override
    public Boolean deleteBlog(Long id) {
        BlogEntity blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        blogRepository.delete(blog);
        return true;
    }

    @Override
    public List<BlogEntity> findAll() {
        return blogRepository.findAll();
    }
}
