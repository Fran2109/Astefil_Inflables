package com.Astefil_Inflables.Catalogo.Backend.repositories;

import com.Astefil_Inflables.Catalogo.Backend.models.Zone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends CrudRepository<Zone, Long> {
}
