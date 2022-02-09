package com.alexeydev.lojajogos.controllers;

import com.alexeydev.lojajogos.dtos.request.JogoRequest;
import com.alexeydev.lojajogos.dtos.response.JogoResponse;
import com.alexeydev.lojajogos.services.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jogo")
public class JogoController {
    private final JogoService jogoService;

    @PostMapping
    public ResponseEntity<JogoResponse> criar(@RequestBody @Valid JogoRequest jogoRequest) {
        JogoResponse jogoResponse = jogoService.criar(jogoRequest);

        return ResponseEntity.created(null).body(jogoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponse> listarPorId(@PathVariable Long id) {
        JogoResponse jogoResponse = jogoService.listarPorId(id);

        return ResponseEntity.ok(jogoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<JogoResponse> atualizar(@RequestBody JogoRequest jogoRequest,@PathVariable Long id) {
        JogoResponse jogoResponse = jogoService.atualizar(jogoRequest, id);

        return ResponseEntity.ok(jogoResponse);
    }

    @GetMapping
    public ResponseEntity<List<JogoResponse>> listarTodos() {
        List<JogoResponse> jogoResponses = jogoService.listarTodos();

        return ResponseEntity.ok(jogoResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        jogoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
