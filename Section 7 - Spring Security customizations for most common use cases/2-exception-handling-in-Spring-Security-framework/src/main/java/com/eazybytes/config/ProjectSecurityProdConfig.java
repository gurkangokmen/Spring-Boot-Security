package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class ProjectSecurityProdConfig {

    //
    // If you don't specify the requiresChannel() method, the defaultly is to allow both HTTP and HTTPS.
    // http.requiresChannel((rcc) -> rcc.anyRequest().requiresInsecure())
    // http.requiresChannel((rcc) -> rcc.anyRequest().requiresSecure())
    //



    // rcc -> requiresChannelConfig (abbreviation)
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.requiresChannel((rcc) -> rcc.anyRequest().requiresSecure()) // Only HTTPS
                .csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .requestMatchers("/notices", "/contact", "/error", "/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }



//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // CHECK FOR COMPROMISED PASSWORD, PASSWORD IS CAN BE HACKED EASILY SO IT RECOMMENDS USE STRONG PASSWORD
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

}
