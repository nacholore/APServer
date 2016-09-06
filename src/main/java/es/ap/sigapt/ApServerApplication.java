package es.ap.sigapt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.Module;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"es.ap.sigapt"})
public class ApServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApServerApplication.class, args);
	}
	
	@Bean
	public Module jtsModule() {
	  return new JtsModule();
	}
}
