package com.alexeydev.lojajogos.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {
    private String mensagem;
    private Integer status;
    private LocalDateTime dataHora;
}
