package microservice.one.customer_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new CustomerService();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http
        //     .csrf().disable()
        //     .authorizeRequests()
        //     .requestMatchers("/customer/").permitAll()
        //     .anyRequest().authenticated()
        //     .and()
        //     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf(Customizer->Customizer.disable())
        .authorizeHttpRequests(request->request.requestMatchers("/auth/**").permitAll())
        .authorizeHttpRequests().anyRequest().authenticated().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(getUserDetailsService());
        // authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
