package br.com.microservico.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservico.loja.client.FornecedorClient;
import br.com.microservico.loja.controller.dto.CompraDTO;
import br.com.microservico.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
//	@Autowired
//	private RestTemplate client;
//	
//	@Autowired
//	private DiscoveryClient eurekaClient;
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	//threadPoolKey divide a threads, com isso não trava as threads em uma única requisição.
	@HystrixCommand(threadPoolKey = "realizaCompra2threadPool")
	public void realizaCompra2(CompraDTO compra) {
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		System.out.println("Estao obtido do fornecedor :"+info.getEndereco());
	}
	
	@HystrixCommand(fallbackMethod = "realizaFallBack", threadPoolKey = "realizaComprathreadPool")
	public void realizaCompra(CompraDTO compra) {
		// RestTemplate client = new RestTemplate(); # não sabe resolver o serviço descoberto pelo eureka, tem que ser o gerenciado pelo spring com @loadbalance
//		ResponseEntity<InfoFornecedorDTO> exchange =
//				client.exchange(Constants.FORNECEDOR_URI+compra.getEndereco().getEstado(),
//						HttpMethod.GET, null, InfoFornecedorDTO.class);
//		
//		eurekaClient.getInstances("fornecedor").stream()
//			.forEach(fornecedor -> {
//				System.out.println("Localhost fornecedor: "+fornecedor.getPort());
//			});
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		System.out.println("Estao obtido do fornecedor :"+info.getEndereco());
	}
	
	public void realizaFallBack(CompraDTO compra) {
		System.out.println("Executei depois de vário erros no método acima");
	}

}
