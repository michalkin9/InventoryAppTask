package com.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class TaskApplication {


	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	public Docket swaggerConf(){
	//return a Docket instance
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.regex("/api/.*")) //which paths
				.apis(RequestHandlerSelectors.basePackage("com.task")) //main package
				.build()
				.apiInfo(apiDeatails());
	}

	private ApiInfo apiDeatails(){
		return new ApiInfo("Inventory items API",
				"API task","1.0","free",
				"Michal Yelkin","","");
	}



}
