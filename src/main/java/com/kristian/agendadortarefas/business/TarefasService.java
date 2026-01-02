package com.kristian.agendadortarefas.business;

import com.kristian.agendadortarefas.business.dto.TarefasDTO;
import com.kristian.agendadortarefas.business.mapper.TarefasConverter;
import com.kristian.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.kristian.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.kristian.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.kristian.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
