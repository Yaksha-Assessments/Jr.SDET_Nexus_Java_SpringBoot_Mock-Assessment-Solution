package com.yaksha.assessments.blogs.testutils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yaksha.assessments.blogs.entity.BlogEntity;

public class MasterData {

	public static BlogEntity getBlogEntity() {
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setId(1L);
		blogEntity.setTitle("Machine Learning");
		blogEntity.setContent("Machine Learning is in the trends now a days");
		return blogEntity;
	}

	public static List<BlogEntity> getBlogEntityList() {
		List<BlogEntity> BlogEntitys = new ArrayList<>();
		BlogEntity BlogEntity = new BlogEntity();
		BlogEntity.setId(1L);
		BlogEntity.setTitle("Machine Learning");
		BlogEntity.setContent("Machine Learning is in the trends now a days");
		BlogEntitys.add(BlogEntity);
		BlogEntity = new BlogEntity();
		BlogEntity.setId(2L);
		BlogEntity.setTitle("Cloud");
		BlogEntity.setContent("Cloud is playing an important role for industries");
		BlogEntitys.add(BlogEntity);
		return BlogEntitys;
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			final String jsonContent = mapper.writeValueAsString(obj);

			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
