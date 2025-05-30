package com.internal.frete.api.controller;

import com.internal.frete.api.dto.CalculoFreteRequest;
import com.internal.frete.api.dto.CalculoFreteResponse;
import com.internal.frete.api.dto.ErroSimplesResponse;
import com.internal.frete.api.service.FreteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calcular-frete")
@AllArgsConstructor
public class FreteController {

    private FreteService freteService;

    @PostMapping("/")
    public ResponseEntity calcularFrete(@RequestBody CalculoFreteRequest request) {

        CalculoFreteResponse calculoFreteResponse = freteService.calcularFreteUnico(request);

        if(calculoFreteResponse==null) return ResponseEntity.unprocessableEntity().body(new ErroSimplesResponse ("Frete não aplicável para esta encomenda e/ou localização."));

        return ResponseEntity.ok().body(calculoFreteResponse);
    }


    @PostMapping("/aplicaveis")
    public ResponseEntity fretesAplicaveis(@RequestBody CalculoFreteRequest request) {

        List<CalculoFreteResponse> fretesAplicaveis = freteService.calcularFretesAplicaveis(request);

        if(fretesAplicaveis==null) return ResponseEntity.unprocessableEntity().body(new ErroSimplesResponse("Nenhum frete está disponível para esta encomenda e/ou localização."));

        return ResponseEntity.ok().body(fretesAplicaveis);
    }

}
