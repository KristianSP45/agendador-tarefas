package com.kristian.agendadortarefas.business.mapper;

import com.kristian.agendadortarefas.business.dto.TarefasDTO;
import com.kristian.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "Spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//nullValuePropertyMappingStrategy = IGNORE = “Se o valor do DTO for null, NÃO copie para a entity”
public interface TarefasUpdateConverter {

    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);//@MappingTarget =
    //Sem isso ❌ “vou criar um novo objeto”
    //Com isso ✅ “vou ALTERAR esse objeto que já existe”
}
