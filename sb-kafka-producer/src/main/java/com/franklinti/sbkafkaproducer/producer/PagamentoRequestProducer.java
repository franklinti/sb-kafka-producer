package com.franklinti.sbkafkaproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.franklinti.sbkafkaproducer.dto.PagamentoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestProducer {

    private static final Logger LOG = LoggerFactory.getLogger(PagamentoRequestProducer.class);

    @Value("${pagamento.request.topic}")
    private String topicoPagamentoRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public PagamentoRequestProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
       LOG.info("send message='{}' to topic{}",pagamentoDTO,topicoPagamentoRequest);
        String conteudo = objectMapper.writeValueAsString(pagamentoDTO);
        kafkaTemplate.send(topicoPagamentoRequest,conteudo);
        return "Pagamento ennviado para processamento";

    }
}
