package com.alexeydev.lojajogos.dtos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JogoResponse {
    private Long codigo;
    private String nome;
    private String genero;
    private LocalDate dataLancamento;
    private Double preco;
}
