package com.internal.frete.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculoFreteRequest implements Cloneable {
    private double peso;
    private double distancia;
    private String tipoFrete;


    public CalculoFreteRequest(CalculoFreteRequest modelo) {
        this.peso = modelo.getPeso();
        this.distancia = modelo.getDistancia();
        this.tipoFrete = modelo.getTipoFrete();
    }

    @Override
    public Object clone() {
        CalculoFreteRequest copia = null;
        try {
            copia = new CalculoFreteRequest(this);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return copia;
    }
}
