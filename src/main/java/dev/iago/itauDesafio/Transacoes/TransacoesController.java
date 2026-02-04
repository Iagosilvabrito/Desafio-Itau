package dev.iago.itauDesafio.Transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {
    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacoesRepository transacoesRepository;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest trasacaoRequest){
        try{
            transacaoService.validarTransacao(trasacaoRequest);
            transacoesRepository.salvarDados(trasacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @DeleteMapping
    public ResponseEntity deletar(){

        transacoesRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
