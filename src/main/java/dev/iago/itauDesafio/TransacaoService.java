package dev.iago.itauDesafio;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
    List<TransacaoRequest> listarTransacao = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest){
        listarTransacao.add(transacaoRequest);
    }
    public void deletarDados(TransacaoRequest transacaoRequest){

    }
    public void liparDados(){
        listarTransacao.clear();
    }


}
