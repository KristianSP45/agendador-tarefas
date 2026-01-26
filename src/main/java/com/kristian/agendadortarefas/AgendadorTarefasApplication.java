package com.kristian.agendadortarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication//Ela é um combo de 3 anotações:@Configuration, @EnableAutoConfiguration e @ComponentScan
//“Sobe a aplicação, escaneia os pacotes, cria os beans e configura tudo sozinho.”
@EnableFeignClients//“Ei, nessa aplicação existem interfaces anotadas com @FeignClient.
//Cria implementações automáticas delas e registra como beans.” @EnableFeignClients > liga o “modo Feign” da aplicação
public class AgendadorTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorTarefasApplication.class, args);
	}

}
