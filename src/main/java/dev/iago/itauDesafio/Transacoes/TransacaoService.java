package dev.iago.itauDesafio.Transacoes;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {


    public void validarTransacao(@Valid TransacaoRequest transacaoRequest){

        if(transacaoRequest.valor().compareTo(BigDecimal.ZERO) < 0 ){

            throw new IllegalArgumentException("Erro: Isso não é uma transação valida, o valor tem que ser maior que 0");

        }
        if(transacaoRequest.dataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: na data da transação");
        }



    }



}
