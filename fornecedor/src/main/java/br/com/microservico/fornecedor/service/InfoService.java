package br.com.microservico.fornecedor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservico.fornecedor.model.InfoFornecedor;
import br.com.microservico.fornecedor.repository.InfoRepository;

@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;

	public Optional<InfoFornecedor> getInfoPorEstado(String estado) {
		return infoRepository.findByEstado(estado);
	}

}