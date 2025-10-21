package com.marketmas.catalog.controller;


import com.marketmas.catalog.entity.Excess;
import com.marketmas.catalog.service.ExcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/excedentes")

public class ExcessController {

    @Autowired
    ExcessService excessService;

    @GetMapping("/greeting")
    public HashMap<String, String> greeting() {

        HashMap<String, String> message = new HashMap<>();

        message.put("message", "Hello World desde " +
                "ExcessController: Microservicio CatalogService");
        message.put("status", "ok");

        return message;
    }

    @PostMapping
    public ResponseEntity<Excess> publishExcess(@RequestBody Excess excess) {
        return ResponseEntity.ok(excessService.publishExcess(excess));
    }

    @GetMapping
    public ResponseEntity<List<Excess>> getExcesses() {
        return ResponseEntity.ok(excessService.getAllExcesses());
    }

    @PatchMapping("/reservar/{id}")
    public ResponseEntity<Excess> reserveExcess(@PathVariable String id) {


        return ResponseEntity.ok(excessService.reserveExcess(Integer.parseInt(id)));
    }

    @GetMapping("/excedente/{id}")
    public ResponseEntity<Excess> getExcesseById(@PathVariable String id) {
        return ResponseEntity.ok(excessService.getExcessById(Integer.parseInt(id)));
    }


}
