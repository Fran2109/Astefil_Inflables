package com.Astefil_Inflables.Catalogo.Backend.repositories;

import com.Astefil_Inflables.Catalogo.Backend.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
}
