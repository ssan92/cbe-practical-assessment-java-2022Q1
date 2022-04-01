package com.pichincha.practica;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class PracticaApplicationTests {
	
	@Autowired
    ApplicationContext ac;

	@Test
	void contextLoads() {
		PracticaApplication.main(new String[] {});
	}

}
