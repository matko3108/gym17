package src.main.java.com.gym17.gym17;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

}

@Override
protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable();

    http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll();
}
}