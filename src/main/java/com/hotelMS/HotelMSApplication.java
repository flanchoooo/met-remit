package com.hotelMS;

import com.hotelMS.audit.SpringSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class HotelMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelMSApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware(){
        return new SpringSecurityAuditorAware();
    }


}
