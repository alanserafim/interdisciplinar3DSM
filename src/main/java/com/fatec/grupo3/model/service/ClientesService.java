package com.fatec.grupo3.model.service;

import com.fatec.grupo3.model.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientesService {
    List<Cliente> consultaTodos();
    Optional<Cliente> consultaPorCpf(String cpf);
    Optional<Cliente> consultaPorId(Long id);
    Optional<Cliente> save(Cliente cliente);
    void delete (Long id);
    Optional<Cliente> atualiza (Cliente cliente);
}
