package com.mobi7.backend.restservice;

import com.mobi7.backend.model.Posicao;
import com.mobi7.backend.model.PosicaoRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Calendar;
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
            List<Posicao> posicoes;
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            Date end = cal.getTime();

            if (placa != null) {
                posicoes = repository.findByPlacaAndDataBetween(placa, data, end);
            } else {
                posicoes = repository.findByDataBetween(data, end);
            }
            return posicoes;
        } else {
            if (placa != null) {
                Example<Posicao> example = Example.of(new Posicao(placa, null, null, null, null, null));

                List<Posicao> posicoes = repository.findAll(example);
            
                return posicoes;
            }
        }

        return repository.findAll();
    }
}
