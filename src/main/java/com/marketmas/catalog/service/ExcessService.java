package com.marketmas.catalog.service;


import com.marketmas.catalog.entity.Excess;
import com.marketmas.catalog.repository.ExcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcessService {

    @Autowired
    private ExcessRepository excessRepository;

    public Excess publishExcess(Excess excess) {
        return excessRepository.save(excess);

    }

    public List<Excess> getAllExcesses(){
        return excessRepository.findAll();
    }

    public Excess reserveExcess(Integer id){

      Optional<Excess> excess = excessRepository.findById(id);

        if(excess.isPresent()){
            Excess excessModify = excess.get();
            excessModify.setStatus("RESERVADO");
            excessRepository.save(excessModify);
        }
        return null;
    }

    public Excess getExcessById(Integer Id){
        if(excessRepository.findById(Id).isPresent()){
            return excessRepository.findById(Id).get();
        }
        return null;
    }



}
