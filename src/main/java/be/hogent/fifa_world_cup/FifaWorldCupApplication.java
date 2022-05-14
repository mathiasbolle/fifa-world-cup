package be.hogent.fifa_world_cup;

import be.hogent.fifa_world_cup.validator.PurchaseValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import service.*;

@SpringBootApplication
public class FifaWorldCupApplication {
	public static void main(String[] args) {
		SpringApplication.run(FifaWorldCupApplication.class, args);
	}
	@Bean
	public JpaWedstrijdDao wedstrijdDao() {
		return new JpaWedstrijdDao();
	}

	@Bean
	public JpaStadionDao stadionDao() {
		return new JpaStadionDao();
	}

	@Bean
	public JpaWedstrijdTicketDao wedstrijdTicketDao() {
		return new JpaWedstrijdTicketDao();
	}

	//this was before we use the database
	@Bean
	public VoetbalService voetbalService() {
		return new VoetbalServiceImpl();
	}



	@Bean
	public PurchaseValidator purchaseValidator() {
		return new PurchaseValidator();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource =
				new ResourceBundleMessageSource();
		messageSource.setBasename("converter");
		return messageSource;

	}
}
