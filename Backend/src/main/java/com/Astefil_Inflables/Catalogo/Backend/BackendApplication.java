package com.Astefil_Inflables.Catalogo.Backend;

import com.Astefil_Inflables.Catalogo.Backend.models.Article;
import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import com.Astefil_Inflables.Catalogo.Backend.services.ArticleServiceImpl;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IArticleService;
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
	CommandLineRunner run(@Autowired ICategoryService categoryService, @Autowired IArticleService articleService) {
		return args -> {
			// Create default categories
			Category acuaticosCategory = categoryService.createCategory("Acuaticos");
			Category gigantesCategory = categoryService.createCategory("Gigantes");
			Category castillosCategory = categoryService.createCategory("Castillos");
			Category juegosCategory = categoryService.createCategory("Juegos");

			// Create default castillos articles
			Article hombreArania = articleService.createArticle("Hombre Araña", "Hombre Araña", (float) 1, (float) 1, (float) 1, castillosCategory);
			Article princesas = articleService.createArticle("Princesas", "Princesas", (float) 1, (float) 1, (float) 1, castillosCategory);
			Article tresPorSeis = articleService.createArticle("3x6", "3x6", (float) 1, (float) 1, (float) 1, castillosCategory);
			Article cuatroPorCinco = articleService.createArticle("4x5", "4x5", (float) 1, (float) 1, (float) 1, castillosCategory);
			Article dosPorDos = articleService.createArticle("2x2", "2x2", (float) 1, (float) 1, (float) 1, castillosCategory);

			// Create default gigantes articles
			Article demoledor = articleService.createArticle("Demoledor", "Demoledor", (float) 1, (float) 1, (float) 1, gigantesCategory);
			Article arcoiris = articleService.createArticle("Arcoiris", "Arcoiris", (float) 1, (float) 1, (float) 1, gigantesCategory);
			Article carreraDeObstaculos = articleService.createArticle("Carrera de obstaculos", "Carrera de obstaculos", (float) 1, (float) 1, (float) 1, gigantesCategory);
			Article barcoPirata = articleService.createArticle("Barco pirata", "Barco pirata", (float) 1, (float) 1, (float) 1, gigantesCategory);

			// Create default acuaticos articles
			Article deslizador = articleService.createArticle("Deslizador", "Deslizador", (float) 1, (float) 1, (float) 1, acuaticosCategory);
			Article rampaAcuaticaArco = articleService.createArticle("Rampa acuatica arco", "Rampa acuatica arco", (float) 1, (float) 1, (float) 1, acuaticosCategory);
			Article rampaAcuatica = articleService.createArticle("Rampa acuatica", "Rampa acuatica", (float) 1, (float) 1, (float) 1, acuaticosCategory);
			Article toboganAcuatico = articleService.createArticle("Tobogan acuatico", "Tobogan acuatico", (float) 1, (float) 1, (float) 1, acuaticosCategory);

			// Create default juegos articles
			Article metegol = articleService.createArticle("Metegol", "Metegol", (float) 1, (float) 1, (float) 1, juegosCategory);
			Article tejo = articleService.createArticle("Tejo", "Tejo", (float) 1, (float) 1, (float) 1, juegosCategory);
			Article sapo = articleService.createArticle("Sapo", "Sapo", (float) 1, (float) 1, (float) 1, juegosCategory);
			Article pool = articleService.createArticle("Pool", "Pool", (float) 1, (float) 1, (float) 1, juegosCategory);
			Article pingPong = articleService.createArticle("Ping pong", "Ping pong", (float) 1, (float) 1, (float) 1, juegosCategory);
			Article yenga = articleService.createArticle("Yenga", "Yenga", (float) 1, (float) 1, (float) 1, juegosCategory);
		};
	}
}
