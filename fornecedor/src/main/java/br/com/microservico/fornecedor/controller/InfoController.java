package br.com.microservico.fornecedor.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservico.fornecedor.model.InfoFornecedor;
import br.com.microservico.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping(value = "/{estado}")
	public InfoFornecedor infoPorEstado(@PathVariable String estado) {
		System.out.println("Estado "+estado);
		
		LOG.info("Acessando serviço de estado");
		Optional<InfoFornecedor> info = infoService.getInfoPorEstado(estado);
		if (info.isPresent()) {
			System.out.println("Info carregada !");
			return info.get();
		}
		return null;
	}

}
