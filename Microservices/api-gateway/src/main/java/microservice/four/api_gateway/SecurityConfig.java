package microservice.four.api_gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Autowired
    JwtTokenFilter filter;
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        // http
        //     .csrf().disable()
        //     .authorizeRequests()
        //     .requestMatchers("/customer/").permitAll()
        //     .anyRequest().authenticated()
        //     .and()
        //     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf(Customizer->Customizer.disable())
        .authorizeExchange().pathMatchers("/auth/**").permitAll()
        .anyExchange().authenticated();//.and()
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}
