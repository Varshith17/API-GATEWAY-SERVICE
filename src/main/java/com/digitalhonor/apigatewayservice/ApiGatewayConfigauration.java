package com.digitalhonor.apigatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfigauration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/auth/**").uri("lb://authentication-service"))
				.route(p -> p.path("/returns/**").uri("lb://component-processing-service"))
				.route(p -> p.path("/packagingAndDelivery/**").uri("lb://packaging-delivery-service")).build();
	}
}
