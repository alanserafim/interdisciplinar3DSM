package com.fatec.grupo3.model.service.implementation;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fatec.grupo3.model.entities.Aula;
import com.fatec.grupo3.model.repositories.AulaRepository;
import com.fatec.grupo3.model.service.AulaService;

@Service
public class AulaServiceImpl implements AulaService{
	Logger logger = LogManager.getLogger(this.getClass());
	
	@Autowired
	private AulaRepository repository;
	
	@Override
	public List<Aula> consultaTodos(){
		logger.info(">>>> servico de consulta todos");
		return repository.findAll();
	}
	
	@Override
	public Optional<Aula> consultaPorTitulo(String titulo){
		logger.info(">>>> servico comsulta por titulo");
		return repository.findAulaByTitulo(titulo);
	}
	
	@Override
	public Optional<Aula> save(Aula aula){
		logger.info(">>>> Servico save chamado");
		Optional<Aula> umAula = consultaPorTitulo(aula.getTitulo());
		
		if(umAula.isEmpty()) {
			logger.info(">>>> Servico save");
			return Optional.ofNullable(repository.save(aula));
		}else {
			return Optional.empty();
		}
	}
	
	 @Override
	    public void delete(Long id) {

	        repository.deleteById(id);

	    }
	 
	 @Override
	 public Optional<Aula> atualiza(Aula aula){
		 logger.info(">>>> Servico atualiza chamado");
		 Optional<Aula> umAula = consultaPorTitulo(aula.getTitulo());
		 
			if(umAula.isEmpty()) {
				logger.info(">>>> Servico save");
				return Optional.ofNullable(repository.save(aula));
			}else {
				return Optional.empty();
			}
		
	 }
	 
	    @Override
	    public Optional<Aula> consultarPorId(Long id) {
	        return repository.findById(id);
	    }
	
}
