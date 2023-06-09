package com.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
	Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("Param", "MyValue"))
				.uri("http://httpbin.org:80");
		return builder.routes().route(routeFunction)
				.route(p -> p.path("/users/**").uri("lb://USER-SERVICE"))
				.route(p -> p.path("/hotels/**").uri("lb://HOTEL-SERVICE"))
				.route(p -> p.path("/ratings/**").uri("lb://RATING-SERVICE"))
//				.route(p -> p.path("/currency-conversion-new/**").filters(f -> f
//						.rewritePath("/currency-conversion-new/(?<segment>)", "/currency-conversion-feign/${segment}"))
//						.uri("lb://currency-conversion"))
				.build();
	}
}
