package com.wizard.security.config;

import com.wizard.security.custom.filter.CustomTokenFilter;
import com.wizard.security.custom.filter.PrintLogFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;
    @Autowired
    private PrintLogFilter printLogFilter;
    @Autowired
    private List<AuthenticationProvider> authenticationProviders;
    @Autowired
    private AuthenticationManager authenticationManager;


    public CustomTokenFilter customTokenFilter(){
        CustomTokenFilter customTokenFilter = new CustomTokenFilter("/**");
        customTokenFilter.setAuthenticationManager(authenticationManager);
        return customTokenFilter;
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated();

        /*******************************************************************/
        //role
        //http.authorizeRequests().anyRequest().hasRole("ADMIN").and().formLogin().and().httpBasic();

        //http.authorizeRequests().anyRequest().permitAll();

//        http.authorizeHttpRequests(authorize ->
//                        authorize
//                                .mvcMatchers("/ready/security/get").hasRole("USER")
//                                .mvcMatchers("/ready/security/test").hasRole("ADMIN"))
//                .httpBasic();

//        http.authorizeRequests()
//                .mvcMatchers("/ready/security/get").hasRole("USER")
//                .mvcMatchers("/ready/security/test").hasRole("ADMIN");
//        http.csrf().disable().authorizeRequests()
//                .mvcMatchers( HttpMethod.GET,"/ready/security/samePath/test").hasRole("USER")
//                .mvcMatchers( HttpMethod.DELETE, "/ready/security/samePath/test").hasRole("ADMIN")
//                .and().httpBasic();

        //configurate custom filter

        http.addFilterBefore(customTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        authenticationProviders.forEach( provider -> builder.authenticationProvider(provider));
//        UserDetails adminUser = User.withUsername("wizard1").password("1234").authorities("DELETE").build();
//        builder.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser(adminUser);

        //create a new admin user
//        UserDetails adminUser = User.withUsername("wizard1").password("1234").roles("ADMIN").build();
//        builder.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser(adminUser);

//        UserDetails user1 = User.withUsername("user_wizard")
//                .password("12345")
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withUsername("admin_wizard")
//                .password("12345")
//                .roles("ADMIN")
//                .build();
//        builder.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("wizard1").password("1234").roles("USER")
//                .and()
//                .withUser("wizard2").password("12345").roles("ADMIN")
//                .and().withUser(user1).withUser(user2);

//        UserDetails user1 = User.withUsername("wizard1")
//                .password("12345")
//                .authorities("read", "write")
//                .accountExpired(false)
//                .disabled(true)
//                .build();
//        builder.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser(user1);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
