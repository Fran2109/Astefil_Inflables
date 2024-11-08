package com.Astefil_Inflables.Catalogo.Backend;

import com.Astefil_Inflables.Catalogo.Backend.models.*;
import com.Astefil_Inflables.Catalogo.Backend.services.ArticleServiceImpl;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(@Autowired IUserService userService, @Autowired ICategoryService categoryService, @Autowired IArticleService articleService, @Autowired IZoneService zoneService, @Autowired IImageService imageService){
		return args -> {
			// Initialize uploads folder
			imageService.deleteAll();
			imageService.init();

			// Create default roles
			Role admin = new Role("ADMIN");
			Role employee = new Role("EMPLOYEE");
			userService.createRole(admin);
			userService.createRole(employee);

			// Create default users
			User userAdmin = userService.createUser(new User("useradmin", "pass123", admin));
			User userEmployee = userService.createUser(new User("useremployee", "pass123", employee));

			// Create default categories
			Category acuaticosCategory = categoryService.createCategory("Acuaticos");
			Category gigantesCategory = categoryService.createCategory("Gigantes");
			Category castillosCategory = categoryService.createCategory("Castillos");
			Category juegosCategory = categoryService.createCategory("Juegos");

			// Create default images
			File imagesFolder = new File("src/main/resources/images");
			File[] hombreAraniaImages = new File(imagesFolder.getPath() + "/hombre_arania").listFiles();
			File[] princesasImages = new File(imagesFolder.getPath() + "/princesas").listFiles();
			File[] tresPorSeisImages = new File(imagesFolder.getPath() + "/3x6").listFiles();
			File[] cuatroPorCincoImages = new File(imagesFolder.getPath() + "/4x5").listFiles();
			File[] dosPorDosImages = new File(imagesFolder.getPath() + "/2x2").listFiles();
			File[] demoledorImages = new File(imagesFolder.getPath() + "/demoledor").listFiles();
			File[] arcoirisImages = new File(imagesFolder.getPath() + "/arcoiris").listFiles();
			File[] carreraDeObstaculosImages = new File(imagesFolder.getPath() + "/carrera_de_obstaculos").listFiles();
			File[] barcoPirataImages = new File(imagesFolder.getPath() + "/barco_pirata").listFiles();
			File[] deslizadorImages = new File(imagesFolder.getPath() + "/deslizador").listFiles();
			File[] rampaAcuaticaArcoImages = new File(imagesFolder.getPath() + "/rampa_acuatica_arco").listFiles();
			File[] rampaAcuaticaImages = new File(imagesFolder.getPath() + "/rampa_acuatica").listFiles();
			File[] toboganAcuaticoImages = new File(imagesFolder.getPath() + "/tobogan_acuatico").listFiles();
			File[] metegolImages = new File(imagesFolder.getPath() + "/metegol").listFiles();
			File[] tejoImages = new File(imagesFolder.getPath() + "/tejo").listFiles();
			File[] sapoImages = new File(imagesFolder.getPath() + "/sapo").listFiles();
			File[] poolImages = new File(imagesFolder.getPath() + "/pool").listFiles();
			File[] pingPongImages = new File(imagesFolder.getPath() + "/ping_pong").listFiles();
			File[] yengaImages = new File(imagesFolder.getPath() + "/yenga").listFiles();

			// Create default castillos articles
			Article hombreArania = articleService.createArticle("Hombre Araña", "Hombre Araña", (float) 1, (float) 1, (float) 1, castillosCategory, hombreAraniaImages);
			Article princesas = articleService.createArticle("Princesas", "Princesas", (float) 1, (float) 1, (float) 1, castillosCategory, princesasImages);
			Article tresPorSeis = articleService.createArticle("3x6", "3x6", (float) 1, (float) 1, (float) 1, castillosCategory, tresPorSeisImages);
			Article cuatroPorCinco = articleService.createArticle("4x5", "4x5", (float) 1, (float) 1, (float) 1, castillosCategory, cuatroPorCincoImages);
			Article dosPorDos = articleService.createArticle("2x2", "2x2", (float) 1, (float) 1, (float) 1, castillosCategory, dosPorDosImages);

			// Create default gigantes articles
			Article demoledor = articleService.createArticle("Demoledor", "Demoledor", (float) 1, (float) 1, (float) 1, gigantesCategory, demoledorImages);
			Article arcoiris = articleService.createArticle("Arcoiris", "Arcoiris", (float) 1, (float) 1, (float) 1, gigantesCategory, arcoirisImages);
			Article carreraDeObstaculos = articleService.createArticle("Carrera de obstaculos", "Carrera de obstaculos", (float) 1, (float) 1, (float) 1, gigantesCategory, carreraDeObstaculosImages);
			Article barcoPirata = articleService.createArticle("Barco pirata", "Barco pirata", (float) 1, (float) 1, (float) 1, gigantesCategory, barcoPirataImages);

			// Create default acuaticos articles
			Article deslizador = articleService.createArticle("Deslizador", "Deslizador", (float) 1, (float) 1, (float) 1, acuaticosCategory, deslizadorImages);
			Article rampaAcuaticaArco = articleService.createArticle("Rampa acuatica arco", "Rampa acuatica arco", (float) 1, (float) 1, (float) 1, acuaticosCategory, rampaAcuaticaArcoImages);
			Article rampaAcuatica = articleService.createArticle("Rampa acuatica", "Rampa acuatica", (float) 1, (float) 1, (float) 1, acuaticosCategory, rampaAcuaticaImages);
			Article toboganAcuatico = articleService.createArticle("Tobogan acuatico", "Tobogan acuatico", (float) 1, (float) 1, (float) 1, acuaticosCategory, toboganAcuaticoImages);

			// Create default juegos articles
			Article metegol = articleService.createArticle("Metegol", "Metegol", (float) 1, (float) 1, (float) 1, juegosCategory, metegolImages);
			Article tejo = articleService.createArticle("Tejo", "Tejo", (float) 1, (float) 1, (float) 1, juegosCategory, tejoImages);
			Article sapo = articleService.createArticle("Sapo", "Sapo", (float) 1, (float) 1, (float) 1, juegosCategory, sapoImages);
			Article pool = articleService.createArticle("Pool", "Pool", (float) 1, (float) 1, (float) 1, juegosCategory, poolImages);
			Article pingPong = articleService.createArticle("Ping pong", "Ping pong", (float) 1, (float) 1, (float) 1, juegosCategory, pingPongImages);
			Article yenga = articleService.createArticle("Yenga", "Yenga", (float) 1, (float) 1, (float) 1, juegosCategory, yengaImages);

			// Create default zones
			zoneService.createZone("Tortuguitas");
			zoneService.createZone("Grand Bourg");
			zoneService.createZone("Tierras Altas");
			zoneService.createZone("Pablo Nogués");
			zoneService.createZone("Los Polvorines");
			zoneService.createZone("Villa de Mayo");
			zoneService.createZone("Manuel Alberti");
			zoneService.createZone("Del Viso");
			zoneService.createZone("Ingeniero Adolfo Sourdeaux");
			zoneService.createZone("José C. Paz");
			zoneService.createZone("Villa Rosa");
		};
	}
}
