package br.edu.infnet.isabellaaraujo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IsabellaaraujoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsabellaaraujoApplication.class, args);
	}

}
