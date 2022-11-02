package study.spring.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import study.spring.practice.domain.MyUserDetails;
import study.spring.practice.domain.User;
import study.spring.practice.service.UserService;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http.csrf()
                .ignoringAntMatchers("/h2-console/**")
                .ignoringAntMatchers("/user/register");

        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/user/register").permitAll()
                .antMatchers(HttpMethod.POST, "/user/register").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .permitAll();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
