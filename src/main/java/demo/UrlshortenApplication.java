package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller","demo","urlshortner"})
@EnableJpaRepositories("dao")
@EntityScan("entity")
public class UrlshortenApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlshortenApplication.class, args);
	}
}
