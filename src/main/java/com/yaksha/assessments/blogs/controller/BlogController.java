package com.yaksha.assessments.blogs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.blogs.entity.BlogEntity;
import com.yaksha.assessments.blogs.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping
	public ResponseEntity<BlogEntity> createBlog(@Valid @RequestBody BlogEntity blogEntity) {
		// write your logic here
		BlogEntity created = blogService.createBlog(blogEntity);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BlogEntity> getBlogById(@PathVariable Long id) {
		// write your logic here
		BlogEntity blog = blogService.getBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<BlogEntity> updateBlog(@RequestBody BlogEntity BlogEntity) {
		// write your logic here
		BlogEntity updated = blogService.updateBlog(BlogEntity);
        return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBlogById(@PathVariable Long id) {
		// write your logic here
		Boolean deleted = blogService.deleteBlog(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<BlogEntity>> getAllBlogs() {
		// write your logic here
		List<BlogEntity> blogs = blogService.findAll();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
	}
}
