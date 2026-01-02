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
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return  tarefasConverter.paraListaTarefasDTO(
                tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extractUsername(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

        return  tarefasConverter.paraListaTarefasDTO(listaTarefas);
    }
}
