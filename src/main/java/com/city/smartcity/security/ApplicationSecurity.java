package com.city.smartcity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/login","/register","/","/apropos","/contact").permitAll()
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .antMatchers("/etudiant").hasAnyRole("ETUDIANT","ADMIN")
                .antMatchers("/tourisme").hasAnyRole("TOURISTE","ADMIN")
                .antMatchers("/api/tourisme").hasAnyRole("TOURISTE","ADMIN")
                .antMatchers("/affaire").hasAnyRole("AFFAIRE","ADMIN")
                .antMatchers("/emploi").hasAnyRole("EMPLOI","ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // Définir la page de connexion personnalisée
                .successHandler(new RoleBasedAuthenticationSuccessHandler())
//                .defaultSuccessUrl("/role") // Redirection après une connexion réussie
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .logout()
                .logoutUrl("/logout") // URL de déconnexion
                .logoutSuccessUrl("/login") // Redirection après une déconnexion réussie
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}
