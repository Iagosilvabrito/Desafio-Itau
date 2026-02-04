package dev.iago.itauDesafio.Estatistica;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

public record EstatisticaDTO(long count, Double avg, Double max, Double min, Double sum){

}
