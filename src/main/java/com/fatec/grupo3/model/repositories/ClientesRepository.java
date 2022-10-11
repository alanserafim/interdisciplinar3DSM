package com.fatec.grupo3.model.repositories;

import java.util.List;
import java.util.Optional;

import com.fatec.grupo3.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository <Cliente, Long>{
    Optional<Cliente> findByCpf(String cpf);
    List<Cliente> findAllByNomeIgnoreCaseContaining(String nome);
}
