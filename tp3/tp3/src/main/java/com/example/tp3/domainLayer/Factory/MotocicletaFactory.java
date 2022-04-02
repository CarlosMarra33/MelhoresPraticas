package com.example.tp3.domainLayer.Factory;

import com.example.tp3.domainLayer.strategy.CalculoStrategy;
import com.example.tp3.domainLayer.strategy.strategyImpl.CalculaPrecoHondaStrategy;
import com.example.tp3.domainLayer.strategy.strategyImpl.CalculoPrecoYamahaStrategy;

public class MotocicletaFactory {

    public static CalculoStrategy selecionarCalculo(String marcaMoto){
        switch (marcaMoto){
            case "yamaha":
                return new CalculoPrecoYamahaStrategy();
            case "honda":
                return new CalculaPrecoHondaStrategy();
            default:
                return null;
        }
    }
}
