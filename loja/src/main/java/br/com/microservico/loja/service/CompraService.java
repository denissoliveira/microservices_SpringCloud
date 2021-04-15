package br.com.microservico.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservico.loja.controller.dto.CompraDTO;
import br.com.microservico.loja.controller.dto.InfoFornecedorDTO;
import br.com.microservico.loja.utils.Constants;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(CompraDTO compra) {
		// RestTemplate client = new RestTemplate(); # não sabe resolver o serviço descoberto pelo eureka, tem que ser o gerenciado pelo spring com @loadbalance
		ResponseEntity<InfoFornecedorDTO> exchange =
				client.exchange(Constants.FORNECEDOR_URI+compra.getEndereco().getEstado(),
						HttpMethod.GET, null, InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
