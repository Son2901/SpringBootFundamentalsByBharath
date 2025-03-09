package com.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Assignment1ApplicationTests {

	@Autowired
	Sum sum;

	@Test
	void testComputeSum() {
		int result = sum.computeSum();
		Assertions.assertEquals(21, result);
	}

}
