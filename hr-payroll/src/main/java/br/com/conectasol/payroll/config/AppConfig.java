package br.com.conectasol.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate resttTemplate() {
		return new RestTemplate();
	}
}
