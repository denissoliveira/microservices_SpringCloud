package br.com.microservico.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.microservico.loja.controller.dto.CompraDTO;
import br.com.microservico.loja.controller.dto.InfoFornecedorDTO;
import br.com.microservico.loja.utils.Constants;

@Service
public class CompraService {
	
	public void realizaCompra(CompraDTO compra) {
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange =
				client.exchange(Constants.FORNECEDOR_URI+compra.getEndereco().getEstado(),
						HttpMethod.GET, null, InfoFornecedorDTO.class);
		System.out.println(exchange.getBody().getEndereco());
	}

}
