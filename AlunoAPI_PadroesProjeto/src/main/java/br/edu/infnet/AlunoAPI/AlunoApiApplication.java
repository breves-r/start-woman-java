package br.edu.infnet.AlunoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AlunoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApiApplication.class, args);
	}

}
