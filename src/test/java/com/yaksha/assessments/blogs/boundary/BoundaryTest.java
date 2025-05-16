package com.yaksha.assessments.blogs.boundary;

import static com.yaksha.assessments.blogs.testutils.TestUtils.boundaryTestFile;
import static com.yaksha.assessments.blogs.testutils.TestUtils.currentTest;
import static com.yaksha.assessments.blogs.testutils.TestUtils.testReport;
import static com.yaksha.assessments.blogs.testutils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yaksha.assessments.blogs.entity.BlogEntity;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {
	private static Validator validator;

	// ----------------------------------------------------------------------------------------------
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testTitleNotNull() throws IOException {
		BlogEntity blogEntity = new BlogEntity();
		blogEntity.setTitle(null); // Title is intentionally set to null.
		blogEntity.setContent("Valid content"); // Content is valid for this test.

		Set<ConstraintViolation<BlogEntity>> violations = validator.validate(blogEntity);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

}
