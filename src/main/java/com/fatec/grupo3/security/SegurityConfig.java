package com.fatec.grupo3.security;

import com.fatec.grupo3.model.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SegurityConfig {
/*
    @Configuration
    @Order(1)
    public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private AuthService authService;

        @Autowired
        private TokenService tokenService;

        @Autowired
        private UsuariosRepository repository;

        @Override
        @Bean
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/api/v1/usuarios/cadastro").permitAll()
                    .antMatchers(HttpMethod.POST,"/api/v1/usuarios/login").permitAll()
                    .and().cors()
                    .and().csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().addFilterBefore(new JwtFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);;
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers( "/**.html", "/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
        }
    }

    @Configuration
    @Order(2)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        private UserDetailsServiceImpl userDetailsService;

        //configuracao de autorizacao
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/clientes").hasAnyRole("ADMIN", "VEND").antMatchers("/fornecedores")
                    .hasRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and()
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
    }*/
}
