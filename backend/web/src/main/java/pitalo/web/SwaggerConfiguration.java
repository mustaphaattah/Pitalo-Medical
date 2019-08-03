package pitalo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("pitalo"))
            .paths(PathSelectors.ant("/api/**"))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Pitalo Medical API",
            "Documentation of Pitalo Medical",
            "Final Version",
            "Free to use",
            new Contact(
                "Nuradeen S. Mohammed",
                "Pitalo-medical.com",
                "nur-sh@pitalo.com"
            ),
            "API License",
            "License URL",
            Collections.emptyList()
        );
    }
}
