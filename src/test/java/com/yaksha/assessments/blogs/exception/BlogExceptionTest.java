package com.yaksha.assessments.blogs.exception;

import static com.yaksha.assessments.blogs.testutils.TestUtils.currentTest;
import static com.yaksha.assessments.blogs.testutils.TestUtils.exceptionTestFile;
import static com.yaksha.assessments.blogs.testutils.TestUtils.testReport;
import static com.yaksha.assessments.blogs.testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assessments.blogs.controller.BlogController;
import com.yaksha.assessments.blogs.service.BlogService;
import com.yaksha.assessments.blogs.entity.BlogEntity;
import com.yaksha.assessments.blogs.testutils.MasterData;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(BlogController.class)
@AutoConfigureMockMvc
public class BlogExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BlogService blogService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateBlogInvalidDataException() throws Exception {
		BlogEntity blogEntity = MasterData.getBlogEntity();
		blogEntity.setTitle(null); // Set invalid data (e.g., null title).

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/blogs")
				.content(MasterData.asJsonString(blogEntity))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("exception test case");
		System.out.println(result.getResponse().getStatus());
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);
	}

}
