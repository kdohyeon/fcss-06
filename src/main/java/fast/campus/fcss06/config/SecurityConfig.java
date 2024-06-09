package fast.campus.fcss06.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationSuccessHandler successHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.httpBasic(Customizer.withDefaults());

//        httpSecurity.httpBasic(c -> c.realmName("REALM_1")
//                .authenticationEntryPoint(new CustomEntryPoint()));
//        httpSecurity.authorizeHttpRequests(a -> a.anyRequest().authenticated());

//        httpSecurity.formLogin(c -> c.defaultSuccessUrl("/home", true));
        httpSecurity.formLogin(c -> c.successHandler(successHandler));
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(a -> a.anyRequest().authenticated());

        return httpSecurity.build();
    }
}
