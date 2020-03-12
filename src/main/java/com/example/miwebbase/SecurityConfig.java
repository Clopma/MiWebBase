package com.example.miwebbase;

import com.example.miwebbase.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select " + User.C_USUARIO + ", " + User.C_CONTRASEÑA + " , 'true' "
                        + "from " +  User.T_USUARIOS  + " "
                        + "where " +  User.C_USUARIO + " = ?");
//                .authoritiesByUsernameQuery("select " +  User.C_USUARIO  + ", 'ROLE_USER' "
//                        + "from " + User.T_USUARIOS + " "
//                        + "where " +  User.C_USUARIO  + " = ?");



    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/inicio", true);
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");

    }


}
