package com.Astefil_Inflables.Catalogo.Backend.repositories;

import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query(value="SELECT MAX(order_number) FROM category;", nativeQuery = true)
    Integer getMaxOrderNumber();
    Category findByOrderNumber(Integer orderNumber);
    List<Category> findAllByOrderByOrderNumberAsc();
}
