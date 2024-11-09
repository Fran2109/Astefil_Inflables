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
import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(@Autowired IUserService userService, @Autowired ICategoryService categoryService, @Autowired IArticleService articleService, @Autowired IZoneService zoneService, @Autowired IImageService imageService, @Autowired IUserQueryService userQueryService){
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
			User userAdmin = userService.createUser(new User("useradmin@gmail.com", "pass123", admin));
			User userEmployee = userService.createUser(new User("useremployee@gmail.com", "pass123", employee));

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
			Zone tortuguitasZone = zoneService.createZone("Tortuguitas");
			Zone grandBourgZone = zoneService.createZone("Grand Bourg");
			Zone tierrasAltasZone = zoneService.createZone("Tierras Altas");
			Zone pabloNoguesZone = zoneService.createZone("Pablo Nogués");
			Zone losPolvorinesZone = zoneService.createZone("Los Polvorines");
			Zone villaDeMayoZone = zoneService.createZone("Villa de Mayo");
			Zone manuelAlbertiZone = zoneService.createZone("Manuel Alberti");
			Zone delVisoZone = zoneService.createZone("Del Viso");
			Zone ingenieroSourdeauxZone = zoneService.createZone("Ingeniero Adolfo Sourdeaux");
			Zone joseCPazZone = zoneService.createZone("José C. Paz");
			Zone villaRosaZone = zoneService.createZone("Villa Rosa");

			// Create default user queries
			userQueryService.createUserQuery("Juan", "Pérez", tortuguitasZone.getId(), LocalDate.now().minusDays(1), "Consulta sobre disponibilidad de castillos", "+5491123456789");
			userQueryService.createUserQuery("María", "Gómez", grandBourgZone.getId(), LocalDate.now().minusDays(2), "Consulta sobre precios de juegos acuáticos", "+5492212345678");
			userQueryService.createUserQuery("Carlos", "López", tierrasAltasZone.getId(), LocalDate.now().minusDays(3), "Consulta sobre disponibilidad de inflables gigantes", "+5491167894321");
			userQueryService.createUserQuery("Ana", "Martínez", pabloNoguesZone.getId(), LocalDate.now().minusDays(4), "Consulta sobre opciones de alquiler", "+5491156784321");
			userQueryService.createUserQuery("Lucía", "Ramírez", losPolvorinesZone.getId(), LocalDate.now().minusDays(5), "Consulta sobre condiciones de alquiler", "+5492212345670");
			userQueryService.createUserQuery("Sofía", "Díaz", villaDeMayoZone.getId(), LocalDate.now().minusDays(6), "Consulta sobre promociones", "+5491145678901");
			userQueryService.createUserQuery("Miguel", "Fernández", manuelAlbertiZone.getId(), LocalDate.now().minusDays(7), "Consulta sobre tamaños de inflables", "+5491167890123");
			userQueryService.createUserQuery("Laura", "Castro", delVisoZone.getId(), LocalDate.now().minusDays(8), "Consulta sobre seguros incluidos", "+5491134567890");
			userQueryService.createUserQuery("Andrés", "Rodríguez", ingenieroSourdeauxZone.getId(), LocalDate.now().minusDays(9), "Consulta sobre disponibilidad en enero", "+5491198765432");
			userQueryService.createUserQuery("Gabriela", "Mendoza", joseCPazZone.getId(), LocalDate.now().minusDays(10), "Consulta sobre opciones para adultos", "+5491134987654");
			userQueryService.createUserQuery("Tomás", "Silva", villaRosaZone.getId(), LocalDate.now().minusDays(11), "Consulta sobre precios de inflables de agua", "+5491143567890");
			userQueryService.createUserQuery("Valeria", "Ortega", tortuguitasZone.getId(), LocalDate.now().minusDays(12), "Consulta sobre métodos de pago", "+5491135674321");
			userQueryService.createUserQuery("Pablo", "Romero", grandBourgZone.getId(), LocalDate.now().minusDays(13), "Consulta sobre cantidad de inflables disponibles", "+5491123478901");
			userQueryService.createUserQuery("Natalia", "Quintero", tierrasAltasZone.getId(), LocalDate.now().minusDays(14), "Consulta sobre instalación incluida", "+5491187654321");
			userQueryService.createUserQuery("Rodrigo", "Sánchez", pabloNoguesZone.getId(), LocalDate.now().minusDays(15), "Consulta sobre horarios de entrega", "+5491145678902");
			userQueryService.createUserQuery("Carolina", "Vega", losPolvorinesZone.getId(), LocalDate.now().minusDays(16), "Consulta sobre paquetes familiares", "+5491156789012");
			userQueryService.createUserQuery("Fernando", "Paredes", villaDeMayoZone.getId(), LocalDate.now().minusDays(17), "Consulta sobre costos adicionales", "+5491198765433");
			userQueryService.createUserQuery("Silvana", "Suárez", manuelAlbertiZone.getId(), LocalDate.now().minusDays(18), "Consulta sobre condiciones de mantenimiento", "+5491176543210");
			userQueryService.createUserQuery("Emanuel", "Luna", delVisoZone.getId(), LocalDate.now().minusDays(19), "Consulta sobre disponibilidad en diciembre", "+5491165432198");
			userQueryService.createUserQuery("Lorena", "Vargas", ingenieroSourdeauxZone.getId(), LocalDate.now().minusDays(20), "Consulta sobre eventos corporativos", "+5491123432109");
		};
	}
}
