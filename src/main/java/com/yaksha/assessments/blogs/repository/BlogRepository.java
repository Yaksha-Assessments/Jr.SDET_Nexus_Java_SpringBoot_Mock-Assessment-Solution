package com.yaksha.assessments.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaksha.assessments.blogs.entity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}
