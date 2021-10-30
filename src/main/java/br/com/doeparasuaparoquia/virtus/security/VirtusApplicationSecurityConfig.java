package br.com.doeparasuaparoquia.virtus.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class VirtusApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	public void configure(HttpSecurity httpSecurity) throws Exception{
		System.out.println("--->> Configurando acessos");
		
		httpSecurity.csrf().disable()
				    .authorizeRequests()
				    // requisicoes liberadas
				    .antMatchers(HttpMethod.GET, "/paroquias/*").permitAll()
				    .antMatchers(HttpMethod.GET, "/paroquias*").permitAll()
				    .antMatchers(HttpMethod.GET, "/estados*").permitAll()
				    .antMatchers(HttpMethod.GET, "/cidades*").permitAll()
				    .antMatchers(HttpMethod.POST, "/login").permitAll()
				    // demais requisiçoes tem que ser autenticadas
				    .anyRequest().authenticated().and().cors();
		
		httpSecurity.addFilterBefore(new VitusTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
