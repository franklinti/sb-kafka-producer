package com.franklinti.sbkafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.franklinti.sbkafkaproducer.dto.PagamentoDTO;
import com.franklinti.sbkafkaproducer.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRequestProducer pagamentoRequestProducer;

    public String integrarPagamento (PagamentoDTO pagamentoDTO){
        try {
            return pagamentoRequestProducer.sendMessage(pagamentoDTO);
        } catch (JsonProcessingException e) {
            return "Erro ao solicitar pagamento"+ e.getMessage();
        }
    }

}
