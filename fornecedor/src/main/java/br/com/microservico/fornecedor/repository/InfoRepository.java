package br.com.microservico.fornecedor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microservico.fornecedor.model.InfoFornecedor;

@Repository
public interface InfoRepository extends JpaRepository<InfoFornecedor, Long>{
	
	Optional<InfoFornecedor> findByEstado(String estado);

}
