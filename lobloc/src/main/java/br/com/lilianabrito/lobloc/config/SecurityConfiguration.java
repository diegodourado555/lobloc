package br.com.lilianabrito.lobloc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("diego").password("diego").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").authenticated()
		                       .antMatchers("/admin").hasRole("ADMIN").and()
							   .exceptionHandling().accessDeniedPage("/unauthorized").and().formLogin().loginPage("/login")
							   .failureUrl("/login?erro=true").defaultSuccessUrl("/home")
							   .loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username")
							   .passwordParameter("j_password").and().logout().logoutUrl("/j_spring_security_logout")
							   .logoutSuccessUrl("/").and().csrf().disable();
	}
}
