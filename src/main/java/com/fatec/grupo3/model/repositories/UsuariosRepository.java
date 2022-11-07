package com.fatec.grupo3.model.repositories;

import java.util.Optional;
import java.util.UUID;

import com.fatec.grupo3.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.username = (:username)")
    public Usuario findByUsername(@Param("username") String username);

    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.email = (:email)")
    public Usuario findByEmail(@Param("email") String email);

    @Query("SELECT e FROM Usuario e JOIN FETCH e.roles WHERE e.cpf = (:cpf)")
    public Usuario findByCpf(@Param("cpf") String cpf);
}
