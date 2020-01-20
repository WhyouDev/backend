package com.bandingin.wahyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan(basePackages = "com.bandingin")
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class WahyuApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(WahyuApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WahyuApplication.class);
	}
	
//	@Bean
//	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
//	  return new BCryptPasswordEncoder(12);
//	}
//	@Bean
//	public CorsFilter corsFilter() {
//	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    final CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    config.setAllowedOrigins(Collections.singletonList("*"));
//	    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
//	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//	    source.registerCorsConfiguration("/**", config);
//	    return new CorsFilter();
//	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();	
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("*").allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
