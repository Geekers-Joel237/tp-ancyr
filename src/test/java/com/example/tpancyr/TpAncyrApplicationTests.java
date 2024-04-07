package com.example.tpancyr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(PostgreSQLTestConfiguration.class)
class TpAncyrApplicationTests {

	@Test
	void contextLoads() {
	}

}
