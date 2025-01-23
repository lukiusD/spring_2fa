package eu.durcak.security2fa.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler(){
        logger.info("----------------- Custom success handler");
        return new OtpAuthSuccessHandler();
    }

    private UserDetailsService customUserDetailsService;
    private TwoFactorAuthenticationFilter twoFactorAuthenticationFilter;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService,
                          TwoFactorAuthenticationFilter twoFactorAuthenticationFilter){
        this.customUserDetailsService = customUserDetailsService;
        this.twoFactorAuthenticationFilter = twoFactorAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(customUserDetailsService)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/allow").permitAll()
                        .anyRequest().authenticated()
                )

                .addFilterBefore(this.twoFactorAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(formLogin -> formLogin

                        .successHandler(customSuccessHandler()));
                        //.defaultSuccessUrl("/dashboard", true));
        // @formatter:on
        return http.build();
    }
}
