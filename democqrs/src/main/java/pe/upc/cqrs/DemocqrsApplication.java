package pe.upc.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class DemocqrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocqrsApplication.class, args);
	}
	
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().
				apis(RequestHandlerSelectors.basePackage("pe.upc.cqrs.controller")).
				// apis(RequestHandlerSelectors.any()).
				paths(PathSelectors.any()).build();
	}

//	private ApiInfo getApiInfo() {
//		return new ApiInfo(
//                "CQRS & ES Ejemplo in Spring Boot y Axon",
//                "Apliacion para probar CQRS & ES con Spring Boot y Axon, ejemplo en base a https://blog.nebrass.fr/",
//                "0.0.1-SNAPSHOT",
//                "Terminos de uso",
//                new Contact("Nebrass Lamouchi", "https://blog.nebrass.fr", "lnibrass@gmail.com"), 
//                "",
//                "",
//                Collections.emptyList()
//				);
//	}

}
