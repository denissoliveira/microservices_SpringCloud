package br.com.microservico.fornecedor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.cloud.config.enabled=false"})
class FornecedorApplicationTests {

	@Test
	void contextLoads() {
	}

}
