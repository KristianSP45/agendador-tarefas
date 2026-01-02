package com.kristian.agendadortarefas.business.mapper;

import com.kristian.agendadortarefas.business.dto.TarefasDTO;
import com.kristian.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);
    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
