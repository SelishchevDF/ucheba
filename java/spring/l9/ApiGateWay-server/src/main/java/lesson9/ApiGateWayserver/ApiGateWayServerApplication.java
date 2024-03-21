package lesson9.ApiGateWayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGateWayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayServerApplication.class, args);


	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("myApp",r->r.path("/myapp/**")
						.uri("http://localhost:8082/")).build();}
}
