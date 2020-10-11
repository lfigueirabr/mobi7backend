package com.mobi7.backend.restservice;

import com.mobi7.backend.model.Posicao;
import com.mobi7.backend.model.PosicaoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PosicaoController {
    private final PosicaoRepository repository;

    public PosicaoController(PosicaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posicao/placas")
    public List<String> getPlacas() {
        return repository.findPlacas();
    }

    @GetMapping("/posicao")
    public List<Posicao> posicaoByPlacaData(@RequestParam(required=false) String placa, @RequestParam(required=false) Date data) {
        if (data != null) {
            List<Posicao> posicao;

            Date end = (Date) data.clone();
            end.setHours(23);
            end.setMinutes(59);
            end.setSeconds(59);

            if (placa != null) {
                posicao = repository.findByPlacaAndDataBetween(placa, data, end);
            } else {
                posicao = repository.findByDataBetween(data, end);
            }
            return posicao;
        } else {
            if (placa != null) {
                Example<Posicao> example = Example.of(new Posicao(placa, null, null, null, null, null));

                List<Posicao> posicao = repository.findAll(example);
            
                return posicao;
            }
        }

        return null;
    }
}
