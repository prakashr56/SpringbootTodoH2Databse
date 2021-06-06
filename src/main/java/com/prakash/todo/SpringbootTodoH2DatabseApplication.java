package com.prakash.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TODO H2 API", version = "2.0", description = "todo services"))
public class SpringbootTodoH2DatabseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTodoH2DatabseApplication.class, args);
	}

}
