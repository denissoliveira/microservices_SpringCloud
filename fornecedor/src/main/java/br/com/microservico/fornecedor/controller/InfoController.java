package br.com.microservico.fornecedor.controller;

import java.util.Optional;

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
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping(value = "/{estado}")
	public InfoFornecedor infoPorEstado(@PathVariable String estado) {
		System.out.println("Estado "+estado);
		Optional<InfoFornecedor> info = infoService.getInfoPorEstado(estado);
		if (info.isPresent()) {
			System.out.println("Info carregada !");
			return info.get();
		}
		return null;
	}

}
