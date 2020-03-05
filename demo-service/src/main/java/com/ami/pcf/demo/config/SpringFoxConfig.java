package com.ami.pcf.demo.config;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.ami.pcf.demo"))
            .paths(PathSelectors.regex("/.*"))
            .build()
            .apiInfo(this.apiInfo())
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500)
                .message("500 message")
                .responseModel(new ModelRef("Error"))
                .build(),
                new ResponseMessageBuilder().code(403)
                    .message("Forbidden!!!!!")
                    .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo Service REST API")
                .description("Demo Service REST API")
                .contact(new Contact("Ami", "www.ami.com", "hnctam@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
