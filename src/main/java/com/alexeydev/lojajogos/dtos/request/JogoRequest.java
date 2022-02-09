package com.alexeydev.lojajogos.dtos.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class JogoRequest {
    @NotBlank(message = "O campo Nome está em branco.")
    private String nome;

    @NotBlank(message = "O campo Gênero está em branco.")
    private String genero;

    @NotNull
    private LocalDate dataLancamento;

    @NotNull(message = "Valor informado é nulo.")
    @Min(value = 0, message = "O preço deve ser maior que 0.")
    private Double preco;
}
