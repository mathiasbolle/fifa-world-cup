package be.hogent.fifa_world_cup;

import domain.Stadion;
import domain.Wedstrijd;
import domain.WedstrijdTicket;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.JpaStadionDao;
import service.JpaWedstrijdDao;
import service.JpaWedstrijdTicketDao;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/fifa");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "root" );
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "domain" });
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());return em;}

    @Bean
    public CommandLineRunner seedDatabase(JpaStadionDao stadionDao, JpaWedstrijdDao wedstrijdDao, JpaWedstrijdTicketDao wedstrijdTicketDao) {
        return (args -> {
            //insert the stadion records
           Stadion s = new Stadion("Al Bayt Stadium");
           Stadion thuma = new Stadion("Al Thumama Stadium");


           stadionDao.insert(s);
           stadionDao.insert(thuma);

           //insert the wedstrijden records
           Wedstrijd belgie_canada = (new Wedstrijd(new String[]{"België", "Canada"}, 26, 11, 35, s));
           Wedstrijd brazilie_zwitserland =(new Wedstrijd(new String[]{"Brazilie", "Zwitserland"}, 27, 11 ,18, s));
           Wedstrijd Marroko_koratie = (new Wedstrijd(new String[]{"Marroko", "Kroatië"}, 28, 11 ,15, s));
           Wedstrijd spanje_duitsland = (new Wedstrijd(new String[]{"Spanje", "Duitsland"}, 28, 11, 18, thuma));
           Wedstrijd  frankrijk_denemarken = (new Wedstrijd(new String[]{"Frankrijk", "Denemarken"}, 30, 11, 18, thuma));
           Wedstrijd argentinie_mexico = new Wedstrijd(new String[]{"Argentinië", "Mexico"}, 30, 11 ,18, s); //6
           Wedstrijd engeland_usa = (new Wedstrijd(new String[]{"Engeland", "USA"}, 30, 11, 18, s));
           Wedstrijd nederland_quatar = (new Wedstrijd(new String[]{"Nederland", "Quatar"}, 30, 11, 21, thuma));

            wedstrijdDao.insert(belgie_canada);
            wedstrijdDao.insert(brazilie_zwitserland);
            wedstrijdDao.insert(Marroko_koratie);
            wedstrijdDao.insert(spanje_duitsland);
            wedstrijdDao.insert(frankrijk_denemarken);
            wedstrijdDao.insert(argentinie_mexico);
            wedstrijdDao.insert(engeland_usa);
            wedstrijdDao.insert(nederland_quatar);

           WedstrijdTicket wt1 = new WedstrijdTicket(belgie_canada, 35);
           WedstrijdTicket wt2 = new WedstrijdTicket(brazilie_zwitserland, 21);
           WedstrijdTicket wt3 = new WedstrijdTicket(Marroko_koratie, 5);
           WedstrijdTicket wt4 = new WedstrijdTicket(spanje_duitsland, 95);
           WedstrijdTicket wt5 = new WedstrijdTicket(frankrijk_denemarken, 45);
           WedstrijdTicket wt6 = new WedstrijdTicket(argentinie_mexico, 10);
           WedstrijdTicket wt7 = new WedstrijdTicket(engeland_usa, 22);
           WedstrijdTicket wt8 = new WedstrijdTicket(nederland_quatar, 16);

           wedstrijdTicketDao.insert(wt1);
           wedstrijdTicketDao.insert(wt2);
           wedstrijdTicketDao.insert(wt3);
           wedstrijdTicketDao.insert(wt4);
           wedstrijdTicketDao.insert(wt5);
           wedstrijdTicketDao.insert(wt6);
           wedstrijdTicketDao.insert(wt7);
           wedstrijdTicketDao.insert(wt8);
        });
    }
}
