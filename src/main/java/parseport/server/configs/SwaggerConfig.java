package parseport.server.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by patrick on 21.05.17.
 */
@Configuration
@EnableSwagger2 //Loads the spring beans required by the framework
public class SwaggerConfig {

        /**
         * Every Docket bean is picked up by the swagger-mvc framework - allowing for multiple
         * swagger groups i.e. same code base multiple swagger resource listings.
         */
        @Bean
        public Docket api(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("parseport.server"))
                    .paths(PathSelectors.any())
                    .build();
        }

}
