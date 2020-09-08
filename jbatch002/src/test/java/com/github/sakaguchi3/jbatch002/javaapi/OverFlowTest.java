package com.github.sakaguchi3.jbatch002.javaapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

public class OverFlowTest {

	@Test
	public void bTest() {
		debug();
	}

	@Test
	public void atomicIntTest() {
		AtomicInteger aint = new AtomicInteger(Integer.MAX_VALUE);
		// over flow
		int d = aint.incrementAndGet();
		assertEquals(-2147483648, d);
	}

	@Test
	void intTest() {
		int max = Integer.MAX_VALUE;
		// over flow
		max++;
		assertEquals(-2147483648, max);
	}

	void debug() {
	}

}
