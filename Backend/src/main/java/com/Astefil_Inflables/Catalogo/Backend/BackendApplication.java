package com.Astefil_Inflables.Catalogo.Backend;

import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(@Autowired ICategoryService categoryService) {
		return args -> {
			// Create default categories
			Category acuaticosCategory = categoryService.createCategory("Acuaticos");
			Category gigantesCategory = categoryService.createCategory("Gigantes");
			Category castillosCategory = categoryService.createCategory("Castillos");
			Category juegosCategory = categoryService.createCategory("Juegos");
		};
	}
}
