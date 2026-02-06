package dev.iago.itauDesafio.Transacoes;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(
        @NotNull
        BigDecimal valor,
        @NotNull
        OffsetDateTime dataHora) {
}
