package be.hogent.fifa_world_cup;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("user")).roles("USER").and()
                .withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests()
                        .antMatchers("/*").hasRole("USER");
        /*
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/fifa/*").hasRole("USER");

         */

        /*
        http.authorizeRequests()
                //.antMatchers(HttpMethod.POST, "fifa/**").
                        .antMatchers("/*").
                hasRole("USER");

        /*
        http.authorizeRequests().
                antMatchers("/**")
                .hasRole("ADMIN");

         */


    }
}
