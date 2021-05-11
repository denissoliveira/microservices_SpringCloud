package br.com.microservico.fornecedor.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservico.fornecedor.model.InfoFornecedor;
import br.com.microservico.fornecedor.repository.InfoRepository;

@Service
public class InfoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);
	
	@Autowired
	private InfoRepository infoRepository;

	public Optional<InfoFornecedor> getInfoPorEstado(String estado) {
		LOG.info("Obtendo estado {}", estado);
		return infoRepository.findByEstado(estado);
	}

}
