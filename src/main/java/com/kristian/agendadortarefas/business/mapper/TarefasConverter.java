package com.kristian.agendadortarefas.business.mapper;

import com.kristian.agendadortarefas.business.dto.TarefasDTO;
import com.kristian.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
////MapStruct = gerador de código em tempo de compilação
import java.util.List;

//MapStruct não é um Builder
@Mapper(componentModel = "spring")//“Gera a implementação e deixa o Spring gerenciar”
//É praticamente um @Component automático, só que gerado pelo MapStruct.
public interface TarefasConverter {
    //“Esse método não tem encapsulamento por causa do @Mapper”

    @Mapping(source = "id", target = "id")//“Diz como um campo vira outro quando não bate sozinho”
    //Nomes iguais + tipos iguais = @Mapping NÃO é necessário
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDTO> dtos);

    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> entities);
}
