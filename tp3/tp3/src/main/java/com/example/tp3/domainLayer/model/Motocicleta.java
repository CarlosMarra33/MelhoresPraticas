package com.example.tp3.domainLayer.model;

import com.example.tp3.domainLayer.model.specifications.MotocicletaSpecification;
import com.example.tp3.domainLayer.strategy.CalculoStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Motocicleta {
    private String id;
    private String modelo;
    private double preco;
    private double taxa;
    private double precoFinal;

    private CalculoStrategy calculoStrategy;

    public Motocicleta(String id, String modelo, double preco, double taxa, double precoFinal) {
        this.id = id;
        this.modelo = modelo;
        this.preco = preco;
        this.taxa = taxa;
        this.precoFinal = precoFinal;
    }

    public void setTaxa(){
        MotocicletaSpecification motocicletaSpecification = new MotocicletaSpecification();
        this.taxa = motocicletaSpecification.setarTaxa(this.preco);
    }

    public void calcularPreco(){
       this.precoFinal = this.calculoStrategy.calculaPrecoFinal(this.preco, this.taxa);
    }
}