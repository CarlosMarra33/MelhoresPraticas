package com.example.tp3.domainLayer.Factory;

import com.example.tp3.domainLayer.model.Motocicleta;
import com.example.tp3.presentationLayer.DTO.MotocicletaDto;

public class MotocicletaFactory {
    public static Motocicleta createMotoFactory(MotocicletaDto motoDto){
        Motocicleta motocicleta = new Motocicleta();
        motocicleta.setId(motoDto.getId());
        motocicleta.setModelo(motoDto.getModelo());
        motocicleta.setPreco(motoDto.getPreco());
        motocicleta.setTaxa();
        motocicleta.setCalculoStrategy(StrategyFactory.selecionarCalculo(motoDto.getMarca()));
        motocicleta.calcularPreco();

        return motocicleta;
    }
}
