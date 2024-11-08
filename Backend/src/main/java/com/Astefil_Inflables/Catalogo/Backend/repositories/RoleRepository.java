package com.Astefil_Inflables.Catalogo.Backend.repositories;

import com.Astefil_Inflables.Catalogo.Backend.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}