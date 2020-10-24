package com.codegym.wdbsspringboot.sercure;

import com.codegym.wdbsspringboot.sercure.userservice.IAppUserService;
import com.codegym.wdbsspringboot.vm.AuditorAwareImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AppSecConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public IAppUserService appUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) appUserService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").hasRole("USER")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling()
                .accessDeniedPage("/accessDenied")

        ;
        http.csrf().disable();
    }
    @Bean
    public AuditorAwareImpl auditorAware(){
        return new AuditorAwareImpl();
    }
}
