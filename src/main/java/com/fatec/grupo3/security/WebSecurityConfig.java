package com.fatec.grupo3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Order(2)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //configuracao de autorizacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/grupo3/**").authorizeRequests()
                .and().formLogin().loginPage("/login").permitAll().and()
                .logout().logoutSuccessUrl("/login?logout").permitAll().and().csrf().disable();
    }

    // configuracao de autenticacao
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jose").password(pc().encode("123")).roles("ADMIN");
        // .and()
        // .withUser("maria").password(pc().encode("456")).roles("VEND");
        auth.userDetailsService(userDetailsService).passwordEncoder(pc());
    }

    @Bean
    public BCryptPasswordEncoder pc() { // cada chamada retorna um resultado diferente
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**", "/css/**", "/js/**", "/images/**", "/h2-console/**",
                "/api/v1/clientes/**");
    }
}
