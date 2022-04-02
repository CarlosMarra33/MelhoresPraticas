package com.example.tp3.presentationLayer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMotoDto {
    private String id;
    private String modelo;
//    private double preco;
    private double taxa;
    private double precoFinal;
}
