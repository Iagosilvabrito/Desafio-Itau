package dev.iago.itauDesafio.Estatistica;

import dev.iago.itauDesafio.Transacoes.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    @Autowired
    private EstatisticasProperties estatisticasProperties;

    @Autowired
    private TransacoesRepository transacoesRepository;


    @GetMapping
    public ResponseEntity estatistica(){
        final var horaInicial = OffsetDateTime.now().minusSeconds(estatisticasProperties.segundos());
        return ResponseEntity.ok(transacoesRepository.estatistica(horaInicial));
    }
}
