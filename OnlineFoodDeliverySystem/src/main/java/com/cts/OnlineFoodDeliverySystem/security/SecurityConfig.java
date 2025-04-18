package com.cts.OnlineFoodDeliverySystem.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Autowired
	    private CustomUserDetailsService customerUserDetailsService;
	 	
	 	@Lazy
	    @Autowired
	    @Qualifier("restaurantAdminDetailsService")
	    private UserDetailsService restaurantAdminUserDetailsService;

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public DaoAuthenticationProvider customerAuthProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(customerUserDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        authProvider.setAuthoritiesMapper(user -> Collections.singletonList(() -> "CUSTOMER")); // Assign CUSTOMER role
	        return authProvider;
	    }

	    @Bean
	    public DaoAuthenticationProvider adminAuthProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(restaurantAdminUserDetailsService);
	        authProvider.setPasswordEncoder(passwordEncoder());
	        authProvider.setAuthoritiesMapper(user -> Collections.singletonList(() -> "ADMIN")); // Assign ADMIN role
	        return authProvider;
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	                .authorizeHttpRequests((requests) -> requests
	                        .requestMatchers("/", "/images/**", "/webjars/**", "/css/**", "/js/**", "/customer/register").permitAll()
	                        .requestMatchers("/customer/**").hasAuthority("CUSTOMER")
	                        .requestMatchers("/admin/register").permitAll()
	                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
	                        .anyRequest().authenticated()
	                )
	                .formLogin((form) -> form
	                        .loginPage("/customer/login")
	                        .defaultSuccessUrl("/customer/dashboard")
	                        .permitAll()
	                        .loginProcessingUrl("/customer/login")
	                        .usernameParameter("email")
	                        .passwordParameter("password")
	                        .failureUrl("/customer/login?error")
	                )
	                .logout((logout) -> logout
	                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                        .permitAll()
	                        .logoutSuccessUrl("/")
	                )
	                .formLogin((form) -> form
	                        .loginPage("/admin/login")
	                        .loginProcessingUrl("/admin/login")
	                        .defaultSuccessUrl("/admin/dashboard")
	                        .permitAll()
	                        .usernameParameter("email")
	                        .passwordParameter("password")
	                        .failureUrl("/admin/login?error")
	                        .loginPage("/admin/login") // Ensure this is set
	                        .failureUrl("/admin/login?error")
	                        .permitAll()
	                )
	                .logout((logout) -> logout
	                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                        .logoutSuccessUrl("/")
	                        .permitAll()
	                        .deleteCookies("JSESSIONID")
	                )
	                .authenticationProvider(customerAuthProvider())
	                .authenticationProvider(adminAuthProvider());

	        return http.build();
	    }
}
