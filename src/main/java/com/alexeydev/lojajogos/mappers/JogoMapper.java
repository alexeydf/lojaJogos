package com.alexeydev.lojajogos.mappers;

import com.alexeydev.lojajogos.dtos.request.JogoRequest;
import com.alexeydev.lojajogos.dtos.response.JogoResponse;
import com.alexeydev.lojajogos.models.Jogo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JogoMapper {
    Jogo toJogo(JogoRequest jogoRequest);

    @Mapping(target = "codigo", source = "id")
    JogoResponse toJogoResponse(Jogo jogo);

    //@Mapping(target = "id", source = "codigo")
    void toJogoAtualizar(@MappingTarget Jogo jogo, JogoRequest jogoRequest);
}
