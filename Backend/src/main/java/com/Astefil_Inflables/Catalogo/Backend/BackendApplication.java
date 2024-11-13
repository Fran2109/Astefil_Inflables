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
			Article hombreArania = articleService.createArticle(
					"Hombre Araña",
					"¡Vive la emoción y trepa junto al Hombre Araña! Este castillo de 4x5 metros te hará sentir como un auténtico superhéroe con un diseño increíble para los fanáticos de Spidey. Ideal para fiestas llenas de aventuras.",
					4.0f, 5.0f, 2.5f, castillosCategory, hombreAraniaImages
			);
			Article princesas = articleService.createArticle(
					"Princesas",
					"Un castillo mágico de 3x4 metros para las reinas y princesas de la casa. Déjate llevar por la fantasía y la diversión en un mundo de ensueño, lleno de colores y detalles reales. Perfecto para fiestas de cuentos de hadas.",
					3.0f, 4.0f, 2.5f, castillosCategory, princesasImages
			);
			Article tresPorSeis = articleService.createArticle(
					"3x6",
					"Un castillo amplio y divertido de 3x6 metros para la mejor experiencia de rebote y juegos. Perfecto para grupos grandes y eventos en los que la diversión no puede faltar.",
					3.0f, 6.0f, 2.8f, castillosCategory, tresPorSeisImages
			);
			Article cuatroPorCinco = articleService.createArticle(
					"4x5",
					"Diversión compacta y segura en un castillo de 4x5 metros. Espacio suficiente para saltar, reír y disfrutar durante horas. Ideal para celebraciones en familia o con amigos.",
					4.0f, 5.0f, 2.5f, castillosCategory, cuatroPorCincoImages
			);
			Article dosPorDos = articleService.createArticle(
					"2x2",
					"El castillo más compacto de 2x2 metros para espacios reducidos, pero igual de divertido. Perfecto para fiestas pequeñas o interiores donde los más pequeños pueden disfrutar sin parar.",
					2.0f, 2.0f, 2.0f, castillosCategory, dosPorDosImages
			);

// Create default gigantes articles
			Article demoledor = articleService.createArticle(
					"Demoledor",
					"¡El gigante Demoledor de 6x8 metros llega para desafiar a los más valientes! Sus dimensiones colosales harán de tu evento una experiencia inolvidable. ¡Atrévete a saltar en esta máquina de emociones!",
					6.0f, 8.0f, 3.5f, gigantesCategory, demoledorImages
			);
			Article arcoiris = articleService.createArticle(
					"Arcoiris",
					"Sumérgete en un arcoíris de alegría y diversión con este gigante inflable de 5x7 metros. Perfecto para añadir color y energía a cualquier evento, ¡los niños lo adorarán!",
					5.0f, 7.0f, 3.2f, gigantesCategory, arcoirisImages
			);
			Article carreraDeObstaculos = articleService.createArticle(
					"Carrera de obstáculos",
					"¡Prepárate para una competencia de 6x10 metros llena de adrenalina! Este inflable tipo carrera de obstáculos garantiza emoción y diversión en cada salto y curva. Ideal para eventos deportivos y desafíos grupales.",
					6.0f, 10.0f, 3.5f, gigantesCategory, carreraDeObstaculosImages
			);
			Article barcoPirata = articleService.createArticle(
					"Barco Pirata",
					"¡A la aventura, marineros! Con este barco pirata inflable de 4x6 metros, los niños podrán surcar mares imaginarios y vivir historias de tesoros escondidos. Perfecto para los pequeños exploradores.",
					4.0f, 6.0f, 3.0f, gigantesCategory, barcoPirataImages
			);

// Create default acuaticos articles
			Article deslizador = articleService.createArticle(
					"Deslizador",
					"Deslízate hacia la diversión con este inflable acuático de 3x8 metros que refrescará cualquier día caluroso. Ideal para fiestas en el verano y momentos de aventura acuática.",
					3.0f, 8.0f, 2.5f, acuaticosCategory, deslizadorImages
			);
			Article rampaAcuaticaArco = articleService.createArticle(
					"Rampa acuática arco",
					"La rampa acuática en forma de arco de 4x10 metros es una atracción espectacular para niños y adultos. ¡Deslízate con velocidad y frescura en este tobogán que hace que el verano sea inolvidable!",
					4.0f, 10.0f, 3.0f, acuaticosCategory, rampaAcuaticaArcoImages
			);
			Article rampaAcuatica = articleService.createArticle(
					"Rampa acuática",
					"Una clásica rampa acuática de 3x8 metros que brinda pura diversión. Perfecta para días soleados y eventos al aire libre, donde todos podrán disfrutar de una refrescante aventura.",
					3.0f, 8.0f, 2.5f, acuaticosCategory, rampaAcuaticaImages
			);
			Article toboganAcuatico = articleService.createArticle(
					"Tobogán acuático",
					"El tobogán acuático es el rey de las atracciones veraniegas. Con sus 4x9 metros, asegura una experiencia de emoción, velocidad y frescura que todos recordarán.",
					4.0f, 9.0f, 3.2f, acuaticosCategory, toboganAcuaticoImages
			);

// Create default juegos articles
			Article metegol = articleService.createArticle(
					"Metegol",
					"El clásico metegol llega para divertir a chicos y grandes. Con amigos o en familia, ¡saca tu mejor equipo y demuestra tus habilidades en este juego lleno de emoción y destreza!",
					1.2f, 2.0f, 0.9f, juegosCategory, metegolImages
			);
			Article tejo = articleService.createArticle(
					"Tejo",
					"Un juego clásico que nunca pasa de moda. El tejo es ideal para desafíos entre amigos y familiares, garantizando entretenimiento y competición en cada lanzamiento.",
					1.5f, 1.5f, 0.8f, juegosCategory, tejoImages
			);
			Article sapo = articleService.createArticle(
					"Sapo",
					"Prueba tu suerte y precisión en el legendario juego del sapo. Diversión asegurada para todas las edades mientras intentas encestar en el sapo y sumar puntos.",
					1.0f, 1.5f, 1.0f, juegosCategory, sapoImages
			);
			Article pool = articleService.createArticle(
					"Pool",
					"La elegancia y el desafío del pool ahora en tu evento. Perfecto para compartir un momento competitivo y relajado con amigos y familia.",
					2.0f, 1.0f, 0.8f, juegosCategory, poolImages
			);
			Article pingPong = articleService.createArticle(
					"Ping pong",
					"La velocidad y agilidad del ping pong llevan la diversión al máximo. Un deporte clásico y atrapante para jugadores de todas las edades. ¡Desafía a tus amigos en una partida inolvidable!",
					2.7f, 1.5f, 0.8f, juegosCategory, pingPongImages
			);
			Article yenga = articleService.createArticle(
					"Yenga",
					"Pura emoción y tensión en el juego de destreza más famoso. Con Yenga, la diversión crece a medida que la torre se tambalea. Perfecto para todos los que aman los desafíos y la estrategia.",
					0.5f, 0.5f, 1.5f, juegosCategory, yengaImages
			);


			// Create default zones
			Zone tortuguitasZone = zoneService.createZone("Tortuguitas", -34.47102820314736, -58.759375465040044);
			Zone grandBourgZone = zoneService.createZone("Grand Bourg", -34.4834089360539, -58.72866440757561);
			Zone tierrasAltasZone = zoneService.createZone("Tierras Altas", -34.478357359271385, -58.739760776250364);
			Zone pabloNoguesZone = zoneService.createZone("Pablo Nogués", -34.481890615079195, -58.69951008650275);
			Zone losPolvorinesZone = zoneService.createZone("Los Polvorines", -34.49962602669663, -58.69159679027918);
			Zone villaDeMayoZone = zoneService.createZone("Villa de Mayo", -34.511258605627546, -58.679712556183816);
			Zone manuelAlbertiZone = zoneService.createZone("Manuel Alberti", -34.434609288289955, -58.7807627626484);
			Zone delVisoZone = zoneService.createZone("Del Viso", -34.447697551623776, -58.80531536306665);
			Zone ingenieroSourdeauxZone = zoneService.createZone("Ingeniero Adolfo Sourdeaux", -34.50246426917496, -58.66751684398748);
			Zone joseCPazZone = zoneService.createZone("José C. Paz", -34.515163383266376, -58.765993597297026);

			// Create default user queries
			userQueryService.createUserQuery("Juan", "Pérez", tortuguitasZone.getId(), LocalDate.now().minusDays(1), "Consulta sobre disponibilidad de castillos", "1123456789");
			userQueryService.createUserQuery("María", "Gómez", grandBourgZone.getId(), LocalDate.now().minusDays(2), "Consulta sobre precios de juegos acuáticos", "2212345678");
			userQueryService.createUserQuery("Carlos", "López", tierrasAltasZone.getId(), LocalDate.now().minusDays(3), "Consulta sobre disponibilidad de inflables gigantes", "1167894321");
			userQueryService.createUserQuery("Ana", "Martínez", pabloNoguesZone.getId(), LocalDate.now().minusDays(4), "Consulta sobre opciones de alquiler", "1156784321");
			userQueryService.createUserQuery("Lucía", "Ramírez", losPolvorinesZone.getId(), LocalDate.now().minusDays(5), "Consulta sobre condiciones de alquiler", "2212345670");
			userQueryService.createUserQuery("Sofía", "Díaz", villaDeMayoZone.getId(), LocalDate.now().minusDays(6), "Consulta sobre promociones", "1145678901");
			userQueryService.createUserQuery("Miguel", "Fernández", manuelAlbertiZone.getId(), LocalDate.now().minusDays(7), "Consulta sobre tamaños de inflables", "1167890123");
			userQueryService.createUserQuery("Laura", "Castro", delVisoZone.getId(), LocalDate.now().minusDays(8), "Consulta sobre seguros incluidos", "1134567890");
			userQueryService.createUserQuery("Andrés", "Rodríguez", ingenieroSourdeauxZone.getId(), LocalDate.now().minusDays(9), "Consulta sobre disponibilidad en enero", "1198765432");
			userQueryService.createUserQuery("Gabriela", "Mendoza", joseCPazZone.getId(), LocalDate.now().minusDays(10), "Consulta sobre opciones para adultos", "1134987654");
			userQueryService.createUserQuery("Tomás", "Silva", joseCPazZone.getId(), LocalDate.now().minusDays(11), "Consulta sobre precios de inflables de agua", "1143567890");
			userQueryService.createUserQuery("Valeria", "Ortega", tortuguitasZone.getId(), LocalDate.now().minusDays(12), "Consulta sobre métodos de pago", "1135674321");
			userQueryService.createUserQuery("Pablo", "Romero", grandBourgZone.getId(), LocalDate.now().minusDays(13), "Consulta sobre cantidad de inflables disponibles", "1123478901");
			userQueryService.createUserQuery("Natalia", "Quintero", tierrasAltasZone.getId(), LocalDate.now().minusDays(14), "Consulta sobre instalación incluida", "1187654321");
			userQueryService.createUserQuery("Rodrigo", "Sánchez", pabloNoguesZone.getId(), LocalDate.now().minusDays(15), "Consulta sobre horarios de entrega", "1145678902");
			userQueryService.createUserQuery("Carolina", "Vega", losPolvorinesZone.getId(), LocalDate.now().minusDays(16), "Consulta sobre paquetes familiares", "1156789012");
			userQueryService.createUserQuery("Fernando", "Paredes", villaDeMayoZone.getId(), LocalDate.now().minusDays(17), "Consulta sobre costos adicionales", "1198765433");
			userQueryService.createUserQuery("Silvana", "Suárez", manuelAlbertiZone.getId(), LocalDate.now().minusDays(18), "Consulta sobre condiciones de mantenimiento", "1176543210");
			userQueryService.createUserQuery("Emanuel", "Luna", delVisoZone.getId(), LocalDate.now().minusDays(19), "Consulta sobre disponibilidad en diciembre", "1165432198");
			userQueryService.createUserQuery("Lorena", "Vargas", ingenieroSourdeauxZone.getId(), LocalDate.now().minusDays(20), "Consulta sobre eventos corporativos", "1123432109");
		};
	}
}
