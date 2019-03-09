package phones;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class AllConfig {

    @Bean
    MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory = new MultipartConfigFactory();
       factory.setMaxFileSize("128MB");
       factory.setMaxRequestSize("128MB");
       return factory.createMultipartConfig();
   }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("phones"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "gis-asu-solution",
                "gis-asu-solution",
                "0.0.1",
                "",
                "",
                " ",
                " ");
        return apiInfo;
    }
}
