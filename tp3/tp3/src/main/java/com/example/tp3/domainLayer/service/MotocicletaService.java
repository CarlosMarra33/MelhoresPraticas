package com.example.tp3.domainLayer.service;

import com.example.tp3.domainLayer.model.Motocicleta;
import com.example.tp3.presentationLayer.DTO.MotocicletaDto;
import com.example.tp3.presentationLayer.DTO.ResponseMotoDto;

import java.util.List;

public interface MotocicletaService {
    public void cadastrarMotocicleta(MotocicletaDto motocicletaDto);
    public List<ResponseMotoDto> listarTodos();
    public ResponseMotoDto pegarUmPeloId(String id);
    public void deletar(String id);
    public void editar(MotocicletaDto motocicletaDto, String idAntigo);
}
