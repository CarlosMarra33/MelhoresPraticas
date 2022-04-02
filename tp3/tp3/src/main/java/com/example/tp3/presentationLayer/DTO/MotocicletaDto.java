package com.example.tp3.presentationLayer.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MotocicletaDto {
    @JsonProperty
    private String modelo;
    @JsonProperty
    private double preco;
    @JsonProperty
    private String marca;
    @JsonProperty
    private String id;
}
