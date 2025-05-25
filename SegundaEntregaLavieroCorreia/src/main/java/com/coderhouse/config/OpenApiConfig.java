package com.coderhouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI custonOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API REST Full | Java | CoderHouse")
						.version("1.0.0")
						.description("La API REST proporciona endpoints para administrar clientes y "
                        		+ "coches en una plataforma. Permite realizar operaciones "
                        		+ "CRUD (Crear, Leer, Actualizar, Eliminar) tanto para clientes como "
                        		+ "para coches y tipos de gamas. Los endpoints permiten listar, agregar, mostrar, "
                        		+ "editar y eliminar clientes y coches. La API está documentada utilizando "
                        		+ "Swagger, lo que facilita la comprensión de los endpoints y su uso.")
						.contact(new Contact()
								.name("Guillermo Laviero Correia")
								.email("guillermo96lc@hotmail.com")
								.url("https://github.com/Guille-LC"))
						.license(new License()
								.name("Licencia")
								.url("https://github.com/Guille-LC/Java-76340"))
						)
						.servers(List.of(
								new Server()
									.url("http://localhost:8080") //http://localhost:8080/swagger-ui/index.html#/
									.description("Servidor Local"),
								new Server()
									.url("http://localhost:5000")
									.description("Servidor de Testing"),
								new Server()
									.url("http://mi-sitio.com")
									.description("Servidor de Producción")
								)
						)
						.externalDocs(new ExternalDocumentation()
								.description("Documentación técnica del proyecto")
								.url("https://github.com/Guille-LC/Java-76340"));
				
		
	}
	

}

