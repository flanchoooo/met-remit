package com.remit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example

		httpSecurity
				.csrf()
				.disable()
				// dont authenticate this particular request
				.authorizeRequests()
				.antMatchers(

						"/authenticate",
						"/register",
						"/password_reset",
						"/login",
						"/activate_account",
						"/platform/**",
						"/v2/api-docs",
						"/configuration/ui",
						"/swagger-resources/**",
						"/configuration/security",
						"/swagger-ui.html",
						"/webjars/**",
						"/user_type/save",

						//ticketing system
						"/ticketing/location",
						"/ticketing/bus",
						"/ticketing/schedule/check-availability",

						// smezim
						"/smezim/company/register",
						"/smezim/message/enquiry",
						"/smezim/payment/instapay",
						"/smezim/payment/paypal",
						"/smezim/secretarial/order",
						"/smezim/services/getall",
						"/smezim/services/{id}",
						"/smezim/shelf-company/getall/available",

                        // payroll
                        "/payroll/company/signup",

						// zfn website
						"/zfn/market-report/recent",
						"/zfn/author/save",
						"/zfn/enquiries/save",
						"/zfn/comments/delete/{id}",
						"/zfn/comments/approve/{id}",
						"/zfn/article/recent",
						"/zfn/article/{id}",
						"/zfn/author/{id}",
						"/zfn/comments/save",
						"/zfn/blog/recent",
						"/zfn/blog/{id}",
						"/zfn/category",
						"/zfn/advert/random",
						"/zfn/archives/type/{type}",
						"/zfn/multimedia/save",
						"/zfn/payment/save",
						"/zfn/payment/uniqueId/{id}",
						"/zfn/payment/update",
						"/zfn/payment/archives",
						"/zfn/multimedia",

						// iq magazine
						"/iq/author/save"
				)
				.permitAll()
				// all other requests need to be authenticated
		.anyRequest()
				.authenticated()
				.and()
				.exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.cors().configurationSource(corsConfigurationSource());
		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD","OPTIONS");
		// .allowCredentials(true);
	}

	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		List<String> allowOrigins = Arrays.asList("*");
		configuration.setAllowedOrigins(allowOrigins);
		configuration.setAllowedMethods(singletonList("*"));
		configuration.setAllowedHeaders(singletonList("*"));
		//in case authentication is enabled this flag MUST be set, otherwise CORS requests will fail
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
