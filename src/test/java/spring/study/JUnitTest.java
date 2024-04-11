package spring.study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

public class JUnitTest {
	@Nested
	@DisplayName("JUnit은 각method마다 새로운 객체를 만들어서 테스트를 진행한다.")
	class JUnit{
		static Set<JUnit> testObjects = new HashSet<>();

		@Test
		public void test1() {
			Assertions.assertFalse(testObjects.contains(this));
			testObjects.add(this);
		}

		@Test
		public void test2() {
			Assertions.assertFalse(testObjects.contains(this));
			testObjects.add(this);
		}

		@Test
		public void test3() {
			Assertions.assertFalse(testObjects.contains(this));
			testObjects.add(this);
		}
	}

	@Nested
	@DisplayName("Spring을 사용해서 테스트 진행시 항상 같은 ApplicationContext를 사용한다.")
	@SpringBootTest
	class SpringTest{
		static ApplicationContext context = null;

		@Autowired
		ApplicationContext applicationContext;

		@Test
		public void test1() {
			Assertions.assertTrue(context == null || context == applicationContext);
			context = applicationContext;
		}

		@Test
		public void test2() {
			Assertions.assertTrue(context == null || context == applicationContext);
			context = applicationContext;
		}

		@Test
		public void test3() {
			Assertions.assertTrue(context == null || context == applicationContext);
			context = applicationContext;
		}

	}
}
