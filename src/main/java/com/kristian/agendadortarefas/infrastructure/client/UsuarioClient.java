package com.kristian.agendadortarefas.infrastructure.client;

import com.kristian.agendadortarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
//Diz pro Spring Cloud OpenFeign: “Essa interface representa uma API externa chamada usuario
//name = "usuario" = Nome lógico do cliente, Usado para logs, métricas, tracing
//url = "${usuario.url}" = Isso vem do application.yml ou properties
public interface UsuarioClient {//Feign exige interface, porque:
    //ele gera a implementação automaticamente
    //você define contrato, não comportamento

    @GetMapping("/usuario")
    UsuarioDTO buscarUsuarioPorEmail(@RequestParam("email") String email,
                                     @RequestHeader("Authorization") String token);
}
//Por que NÃO retorna ResponseEntity?
// Client não deve lidar com HTTP
// Quem lida com HTTP é Controller