package com.alexeydev.lojajogos.services;

import com.alexeydev.lojajogos.dtos.request.JogoRequest;
import com.alexeydev.lojajogos.dtos.response.JogoResponse;
import com.alexeydev.lojajogos.mappers.JogoMapper;
import com.alexeydev.lojajogos.models.Jogo;
import com.alexeydev.lojajogos.repositories.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JogoService {
    private final JogoRepository jogoRepository;
    private final JogoMapper jogoMapper;

    public JogoResponse criar(JogoRequest jogoRequest) {
        Jogo jogo = jogoMapper.toJogo(jogoRequest);

        jogoRepository.save(jogo);

        return jogoMapper.toJogoResponse(jogo);
    }

    public JogoResponse listarPorId(Long id) {
        Jogo jogo = jogoRepository.findById(id).get();

        return jogoMapper.toJogoResponse(jogo);
    }

    public JogoResponse atualizar(JogoRequest jogoRequest, Long id) {
        Jogo jogo = jogoRepository.findById(id).get();

        jogoMapper.toJogoAtualizar(jogo,jogoRequest);

        jogoRepository.save(jogo);

        return jogoMapper.toJogoResponse(jogo);
    }

    public List<JogoResponse> listarTodos() {
        List<Jogo> jogos = jogoRepository.findAll();

        List<JogoResponse> jogoResponses = new ArrayList<>();

        for (Jogo jogo: jogos) {
            jogoResponses.add(jogoMapper.toJogoResponse(jogo));
        }

        return jogoResponses;
    }

    public void excluir(Long id) {
        jogoRepository.deleteById(id);
    }
}
