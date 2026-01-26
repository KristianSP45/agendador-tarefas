package com.kristian.agendadortarefas.infrastructure.repository;

import com.kristian.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.kristian.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
    //extends MongoRepository = Você ganha de graça: save, findById, findAll, deleteById, paginação, sorting

    //List é usado só porque o banco pode retornar vários registros. Simples assim.
    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(
            LocalDateTime dataInicial,
            LocalDateTime dataFinal,
            StatusNotificacaoEnum statusNotificacaoEnum);
    //“Buscar tarefas cuja dataEvento esteja entre dataInicial e dataFinal
    //e cujo statusNotificacaoEnum seja X”

    List<TarefasEntity> findByEmailUsuario(String email);//“Me dá todas as tarefas desse usuário”
}
// ResponseEntity<> = HTTP
// List<> = quantidade(0, 1 ou varios dados)
// Optional<> = pode existir ou não (1)(0 ou 1 dado)