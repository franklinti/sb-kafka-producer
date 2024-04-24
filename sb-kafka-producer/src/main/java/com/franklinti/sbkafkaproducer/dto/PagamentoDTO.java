package com.franklinti.sbkafkaproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    private Integer numero;
    private String descricao;

    private BigDecimal valor;
}
