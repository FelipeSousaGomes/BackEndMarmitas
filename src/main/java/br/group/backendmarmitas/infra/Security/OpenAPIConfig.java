package br.group.backendmarmitas.infra.Security;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${springdoc.api-docs.title}") final String title,
            @Value("${springdoc.api-docs.description}") final String description,
            @Value("${springdoc.api-docs.version}") final String version
    ){
        return new OpenAPI()
                .info(
                        new Info()
                                .title(title)
                                .description(description)
                                .version(version)
                );
    }


}