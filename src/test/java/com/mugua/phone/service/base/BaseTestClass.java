package com.mugua.phone.service.base;

import com.mugua.phone.base.ContextLoader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class BaseTestClass {
	
	//protected static String[] xml={"classpath:resource/app.xml"};
	protected static ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
	protected static String name;
	protected static Object getInstance(String name) {
		return ctx.getBean(name);
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
	}
}
