package dev.iago.itauDesafio.Transacoes;

import dev.iago.itauDesafio.Estatistica.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TransacoesRepository {
    List<TransacaoRequest> listarTransacao = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest){
        listarTransacao.add(transacaoRequest);
    }

    public void deletarDados(){
        listarTransacao.clear();
    }
    public void liparDados(){

    }
    public EstatisticaDTO estatistica(OffsetDateTime horaIncial){

        if (listarTransacao.isEmpty()){
            return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
        }
        var resumo = listarTransacao.stream()
                .filter(t -> t.dataHora().isAfter(horaIncial) || t.dataHora().isEqual(horaIncial))
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();
        return new EstatisticaDTO(resumo.getCount(), resumo.getAverage(), resumo.getMax(), resumo.getMin(), resumo.getSum());
    }
}
