package com.example.tp3.domainLayer.strategy.strategyImpl;

import com.example.tp3.domainLayer.strategy.CalculoStrategy;

public class CalculoPrecoYamahaStrategy implements CalculoStrategy {
    private final double acrescimoYamaha = 1.5;
    @Override
    public double calculaPrecoFinal(double preco, double taxa) {
        double precoFinal = (preco * taxa) * acrescimoYamaha;

        return precoFinal;
    }
}
