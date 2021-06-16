package br.com.microservico.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class LojaApplication {
	
	@Bean
	@LoadBalanced //Para resolver o nome fornecido pelo eureka
	public RestTemplate getRestTemplate() {
		return new RestTemplate(); //Para o spring pode gerenciar, com isso colocar a anotação LoadBalanced
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}
