package be.hogent.fifa_world_cup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.VoetbalService;
import service.VoetbalServiceImpl;

@SpringBootApplication
public class FifaWorldCupApplication {
	public static void main(String[] args) {
		SpringApplication.run(FifaWorldCupApplication.class, args);
	}

	@Bean
	public VoetbalService voetbalService() {
		return new VoetbalServiceImpl();
	}
}
