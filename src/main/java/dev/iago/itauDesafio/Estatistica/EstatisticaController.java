package dev.iago.itauDesafio.Estatistica;

import dev.iago.itauDesafio.Transacoes.TransacoesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private EstatisticasProperties estatisticasProperties;

    @Autowired
    private TransacoesRepository transacoesRepository;


    @GetMapping
    public ResponseEntity estatistica(){
        log.info("Calculando info de transações: ");

        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticasProperties.segundos());
        return ResponseEntity.ok(transacoesRepository.estatistica(horaInicial));
    }
}
