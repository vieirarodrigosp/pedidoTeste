package br.com.meuprojeto.pedidoTeste.configuration;

import java.util.ArrayList;
import java.util.regex.Matcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.meuprojeto.pedidoTeste"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"pedidoTeste"
				, "Projeto de Pedidos, cadastro, exclusão e consulta de pedidos"
				, "1.0"
				, "terms Of Service"
				, new Contact("Rodrigo Vieira Barbosa", "", "rv_rodrigo.vieira@hotmail.com")
				, "Apache License Version 2.0"
				, "https://www.apache.org/license.html", new ArrayList<VendorExtension>());
		
		return apiInfo;	
	}
}