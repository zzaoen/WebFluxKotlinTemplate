//package com.example.wfk.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
//import org.springframework.security.config.web.server.ServerHttpSecurity
//import org.springframework.security.web.server.SecurityWebFilterChain
//
//
///*
// * Author: zzaoen
// * Date: 2020/1/7 15:58
// * Desc: Security configuration
// */
//@EnableWebFluxSecurity
//class SecurityConfig {
//  @Bean
//  @Throws(Exception::class)
//  fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
//    http.csrf().disable()
//    http.oauth2ResourceServer().jwt()
//    http.authorizeExchange()
//            .pathMatchers("/test/**")
//            .permitAll()
//
//    /**
//     * Security setting for metadata API
//     */
//    http.authorizeExchange()
//        .pathMatchers("/metadata/**")
//        .authenticated()
//
//    return http.build()
//  }
//}
