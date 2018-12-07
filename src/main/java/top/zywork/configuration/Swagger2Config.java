package top.zywork.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger2配置<br/>
 *
 * 创建于2018-12-06<br/>
 *
 * @author 王振宇
 * @version 1.0
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.zywork.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("zywork-app接口文档")
                .contact(new Contact("赣州智悦科技有限公司", "http://zywork.top", "847315251@qq.com"))
                .version("1.0")
                .description("zywork-app接口文档 By 赣州智悦科技")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList<>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContextList = new ArrayList<>();
        securityContextList.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                // 可配置哪些url不需要Authorization认证
                // .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .forPaths(PathSelectors.any())
                .build());
        return securityContextList;
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> securityReferenceList = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        securityReferenceList.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferenceList;
    }

}
