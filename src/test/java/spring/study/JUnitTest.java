package spring.study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit은 각method마다 새로운 객체를 만들어서 테스트를 진행한다.")
public class JUnitTest {
	static Set<JUnitTest> testObjects = new HashSet<>();

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
