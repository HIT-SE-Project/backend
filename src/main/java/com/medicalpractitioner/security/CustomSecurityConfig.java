package com.medicalpractitioner.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalpractitioner.security.MyCustomDetailService;
import com.medicalpractitioner.vo.ReturnPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

/**
 * 部分代码
 */
@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Autowired
    private MyCustomDetailService myCustomDetailService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(reg -> reg.requestMatchers(new AntPathRequestMatcher("/api/login")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/register")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/doctor/getDoctorList")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/doctor/getTimeTable")).permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(myCustomDetailService).formLogin(v -> v.loginProcessingUrl("/api/login").usernameParameter("account")  //前端传参
                        .passwordParameter("password").successHandler((request, response, authentication) -> {
                            MyCustomDetail customDetail = (MyCustomDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                            response.getWriter().write(new ObjectMapper().writeValueAsString(ReturnPackage.suc(customDetail.getCustom().getRole())));
                        }).failureHandler((request, response, exception) -> {
                            response.getWriter().write(new ObjectMapper().writeValueAsString(ReturnPackage.pack(401, "account or password error", null)));
                        })).logout(v -> v.logoutUrl("/api/logout").logoutSuccessHandler((request, response, authentication) -> {
                    response.getWriter().write(new ObjectMapper().writeValueAsString(ReturnPackage.suc()));
                }))

                .exceptionHandling(v -> v
                        //未登录
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.getWriter().write(new ObjectMapper().writeValueAsString(ReturnPackage.fail()));
                        })
                        //权限不够
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.getWriter().write(new ObjectMapper().writeValueAsString(ReturnPackage.fail()));
                        })).cors(v -> v.configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.addAllowedOriginPattern("*");
                    cors.setAllowedMethods(List.of("*"));
                    cors.setAllowedHeaders(List.of("*"));
                    cors.setAllowCredentials(true);
                    return cors;
                })).csrf(AbstractHttpConfigurer::disable).build();
    }

}

