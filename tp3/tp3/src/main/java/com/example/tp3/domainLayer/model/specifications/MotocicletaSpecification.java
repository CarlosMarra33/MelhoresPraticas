package com.example.tp3.domainLayer.model.specifications;

public class MotocicletaSpecification {

    public double setarTaxa(double preco){
        if (preco<2000){
            return 15.6;
        }else if (preco>=2000 && preco<50000){
            return 30.5;
        }else {
            return 50.0;
        }
    }
}
