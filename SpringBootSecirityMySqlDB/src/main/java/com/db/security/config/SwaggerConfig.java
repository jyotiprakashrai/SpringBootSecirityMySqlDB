package com.db.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
/*
 * Use following url to get Swagger documentation of API
 * http://localhost:8080/swagger-ui.html
*/


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/rest/hello.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring Boot Security API").description("Spring Boot Security with MySql Authrntication, Authorization API")
				.contact("mr.jyotiprakash@gmail.com").license("No licence")
				.licenseUrl("mr.jyotiprakash@gmail.com").version("2.0").build();
	}

}
