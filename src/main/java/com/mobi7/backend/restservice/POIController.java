package com.mobi7.backend.restservice;

import com.mobi7.backend.model.POI;
import com.mobi7.backend.model.POIRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class POIController {
    private final POIRepository repository;

    public POIController(POIRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pois")
	public List<POI> getPois() {
        return repository.findAll();
    }
    
    @GetMapping("/poi/{nome}")
    public POI poiByNome(@PathVariable String nome) {
        Example<POI> example = Example.of(new POI(nome, null, null, null));

        Optional<POI> poiOptional = repository.findOne(example);

        if (poiOptional.isPresent()) {
            return poiOptional.get();
        } else {
            return null;
        }
    }
}
