package br.com.microservico.loja;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.cloud.config.enabled=false"})
class LojaApplicationTests {

	@Test
	void contextLoads() {
	}

}
