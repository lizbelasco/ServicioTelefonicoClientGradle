package com.soa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soa.dto.CrearReporteResponse;
import com.soa.soap.PhoneServiceClient;

@SpringBootApplication
public class ServicioTelefonicoClientGradleApplication {

	public static final  void  main(String[] args) {
		SpringApplication.run(ServicioTelefonicoClientGradleApplication.class, args);
	}

    @Bean
    CommandLineRunner lookup(PhoneServiceClient client) {
        return args -> {
            CrearReporteResponse response = client.execute();
            System.err.println(response.getCliente().getNombre());
        };
    }

    @Bean
    CommandLineRunner otro() {
        return args -> {
            System.out.println("Soy un objeto especial que corre automáticamente");
        };
    }
}