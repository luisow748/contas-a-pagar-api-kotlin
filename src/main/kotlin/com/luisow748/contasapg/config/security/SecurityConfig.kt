//package com.luisow748.contasapg.config.security
//
//import org.springframework.context.annotation.Bean
//import org.springframework.security.authorization.AuthorityAuthorizationManager.hasAuthority
//import org.springframework.security.config.Customizer
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
//import org.springframework.security.config.web.server.ServerHttpSecurity.http
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//import org.springframework.security.web.SecurityFilterChain
//
//
//@EnableWebSecurity
//class SecurityConfig {
//
//
//    @Bean
//    fun userDetailsService(bCryptPasswordEncoder: BCryptPasswordEncoder): UserDetailsService? {
//        val manager = InMemoryUserDetailsManager()
//        manager.createUser(
//            User.withUsername("user")
//                .password(bCryptPasswordEncoder.encode("userPass"))
//                .roles("USER")
//                .build()
//        )
//        manager.createUser(
//            User.withUsername("admin")
//                .password(bCryptPasswordEncoder.encode("adminPass"))
//                .roles("USER", "ADMIN")
//                .build()
//        )
//        return manager
//    }
//
//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//        http {
//            authorizeRequests {
//                authorize("/greetings/**", hasAuthority("ROLE_ADMIN"))
//                authorize("/**", permitAll)
//            }
//            httpBasic {}
//            return http.build();
//        }
//    }
//
////    @Bean
////    @Throws(Exception::class)
////    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
////        http.csrf().
////            .antMatchers("/user/**")
////            .hasAnyRole("USER", "ADMIN")
////            .antMatchers("/login/**")
////            .anonymous()
////            .anyRequest()
////            .authenticated()
////            .and()
////            .httpBasic()
////            .and()
////            .sessionManagement()
////            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////        return http.build()
////    }
//
////    @Bean
////    @Throws(Exception::class)
////    fun authenticationManager(
////        http: HttpSecurity,
////        bCryptPasswordEncoder: BCryptPasswordEncoder?,
////        userDetailService: UserDetailsService?
////    ): AuthenticationManager? {
////        return http.getSharedObject(AuthenticationManagerBuilder::class.java)
////            .userDetailsService(userDetailsService)
////            .passwordEncoder(bCryptPasswordEncoder)
////            .and()
////            .build()
////    }
//
//}