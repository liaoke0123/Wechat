package com.wechat.friends.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {



	@Bean
	public Docket cmsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("demo")
				.genericModelSubstitutes(DeferredResult.class)
				// .genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.forCodeGeneration(true)
				.pathMapping("/")
//				.globalOperationParameters(new ArrayList<Parameter>() {
//					private static final long serialVersionUID = 1L;
//					{
//						add(new ParameterBuilder().name("Authorization")
//								.description("请求可能需要在HTTP header中加入token。\r\n请填写\"Bearer {token}\"").modelRef(new ModelRef("string"))
//								.parameterType("header").required(false).build());
//					}
//				})
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.wechat.friends.web"))
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.build().apiInfo(cmsApiInfo());
	}

	private ApiInfo cmsApiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("demo API文档", // 大标题
				"本接口信息只做测试用，正式地址为：{发布地址}/{接口地址}", // 小标题
				"0.1", // 版本
				"", "XXX", // 作者
				"", // 链接显示文字
				""// 网站链接
		);
		return apiInfo;
	}

	
	
}