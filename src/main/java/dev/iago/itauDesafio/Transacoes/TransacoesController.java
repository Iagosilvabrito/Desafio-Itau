package dev.iago.itauDesafio.Transacoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacoesRepository transacoesRepository;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest trasacaoRequest){
        log.info("Requisação de transação para o servidor: ");
        try{
            transacaoService.validarTransacao(trasacaoRequest);
            transacoesRepository.salvarDados(trasacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException exception){
            log.error("Erro em uma ou mais validações, tente novemente: ");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        catch (Exception e){
            log.error("Erro no servidor, tente novamente: ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @DeleteMapping
    public ResponseEntity deletar(){
        log.info("Lista de transações deletada: ");
        transacoesRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
