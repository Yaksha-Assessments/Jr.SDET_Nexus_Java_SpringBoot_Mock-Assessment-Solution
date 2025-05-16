package com.yaksha.assessments.blogs.service;

import java.util.List;

import com.yaksha.assessments.blogs.entity.BlogEntity;

public interface BlogService {

	public BlogEntity createBlog(BlogEntity blogEntity);

	public BlogEntity getBlogById(Long id);

	public BlogEntity updateBlog(BlogEntity blogEntity);

	public Boolean deleteBlog(Long id);

	public List<BlogEntity> findAll();
}
