package com.example.tp3.domainLayer.strategy.strategyImpl;

import com.example.tp3.domainLayer.strategy.CalculoStrategy;

public class CalculaPrecoHondaStrategy implements CalculoStrategy {
    private final int acrescentoHonda = 1000;
    @Override
    public double calculaPrecoFinal(double preco, double taxa) {
        double precoFinal = (preco * taxa) + acrescentoHonda;

        return precoFinal;
    }
}
