package com.taha.expense_tracker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker REST API Documentation",
				description = "Expense Tracker REST API Documentation Project",
				version = "v1.0",
				contact = @Contact(
						name = "Taha",
						url = "https://github.com/TahaCn"
				)
		)
)
@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

}
