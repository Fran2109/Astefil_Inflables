package com.Astefil_Inflables.Catalogo.Backend.repositories;

import com.Astefil_Inflables.Catalogo.Backend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    ArrayList<User> findAllByRole_Name(String name);
}
