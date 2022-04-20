package cookingOilReviewSystem.Project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cookingOilReviewSystem.Project.CookingOilReviewSystemApplication;
import cookingOilReviewSystem.Project.domain.Oil;
import cookingOilReviewSystem.Project.domain.OilRepository;
import cookingOilReviewSystem.Project.domain.OilType;
import cookingOilReviewSystem.Project.domain.OilTypeRepository;
import cookingOilReviewSystem.Project.domain.User;
import cookingOilReviewSystem.Project.domain.UserRepository;

@SpringBootApplication
public class CookingOilReviewSystemApplication {

	private static final Logger log = LoggerFactory.getLogger(CookingOilReviewSystemApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CookingOilReviewSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner oilDemo(OilRepository oilrepository, OilTypeRepository typerepository, UserRepository userrepository) {
		return (args) -> {
			log.info("Saving oil types...");
			OilType oil1 = new OilType("Extra Virgin");
			typerepository.save(oil1);
			OilType oil2 = new OilType("Rapeseed");
			typerepository.save(oil2);
			OilType oil3 = new OilType("Canola");
			typerepository.save(oil3);
			
			log.info("save oil");
			oilrepository.save(new Oil("Gran Fruttato", "Monini", 500, "Italy", 4.2, "I like this one, it gives a nice subtle taste to salads and enhances pan frying!", oil1));

			
			log.info("Create admin(admin) and user1(mrbrown) and user2(mrblack)");
			User admin = new User("admin", "$2a$10$i00QBusgixhWN4ZmeDOPHu6AfoYXfXDNEDEc8coL2RaOgeiJFpKlG", "ADMIN");
			User user1 = new User("mrBrown", "$2a$10$BTM1r5WmxZxuvlLPxtuhkOwyb3xGyTKTFZAa2ztEF2iK.N8Ikm7Tq", "USER");
			User user2 = new User("mrBlack", "$2a$10$DNBd1NQi3//0DsgwMc1s2uliiuGP74ANc0gdrN.dC1ghjGCulmbxO", "USER");
			
			userrepository.save(user1);
			userrepository.save(user2);
			userrepository.save(admin);
			
			log.info("fetch all cooking oils");
			for (Oil oil: oilrepository.findAll()) {
				log.info(oil.toString());
			}
		};
	}
}
