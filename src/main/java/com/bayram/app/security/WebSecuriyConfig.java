package com.bayram.app.security;


import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecuriyConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(this.bCryptPasswordEncoder());
    	provider.setUserDetailsService(this.userDetailsService);
    	return provider;
    	
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.authenticationProvider(daoAuthenticationProvider());
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	   http	
    	   	   .csrf().disable()
	           .authorizeRequests()
	           .antMatchers("/login.html","/user/**").permitAll()
	           .antMatchers("/reservation/**","/flight/search",	"/flight/searchPage").authenticated()
	           .antMatchers("/flight/addNewFlight/**").hasAnyAuthority("ADMIN")
	           .antMatchers("/flight/addNewFlight/**").hasRole("ADMIN")
           .and()
	           .formLogin()
	           .loginPage("/login.html").successForwardUrl("/flight/searchPage")
	           .usernameParameter("email")
	           .permitAll()
           .and()
           	   .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login.html?logout=true");	
    }
    

}
