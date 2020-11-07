package com.remit;

import com.remit.audit.SpringSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class RemitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemitApplication.class, args);
    }


    @Bean
    public AuditorAware<String> auditorAware(){
        return new SpringSecurityAuditorAware();
    }


}
