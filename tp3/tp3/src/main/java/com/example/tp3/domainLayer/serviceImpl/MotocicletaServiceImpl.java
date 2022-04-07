package com.example.tp3.domainLayer.serviceImpl;

import com.example.tp3.domainLayer.Factory.MotocicletaFactory;
import com.example.tp3.domainLayer.Factory.StrategyFactory;
import com.example.tp3.domainLayer.model.Motocicleta;
import com.example.tp3.domainLayer.service.MotocicletaService;
import com.example.tp3.infraLayer.repositorio.MotocicletaRepositorio;
import com.example.tp3.presentationLayer.DTO.MotocicletaDto;
import com.example.tp3.presentationLayer.DTO.ResponseMotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotocicletaServiceImpl implements MotocicletaService{

    @Autowired
    MotocicletaRepositorio repositorio;

    @Override
    public void cadastrarMotocicleta(MotocicletaDto motocicletaDto) {
        Motocicleta motocicleta = MotocicletaFactory.createMotoFactory(motocicletaDto);

        repositorio.save(motocicleta);
    }

    @Override
    public List<ResponseMotoDto> listarTodos() {
        List<Motocicleta> listaDeMotosInterna = repositorio.listarTodos();
        List<ResponseMotoDto> listaResposta = new ArrayList<>();

        for (Motocicleta moto : listaDeMotosInterna){
            ResponseMotoDto rMoto = new ResponseMotoDto(moto.getId(), moto.getModelo(), moto.getTaxa(), moto.getPrecoFinal());
            listaResposta.add(rMoto);
        }

        return listaResposta;
    }

    @Override
    public ResponseMotoDto pegarUmPeloId(String id) {
        Motocicleta motoInterno = repositorio.pegarPorId(id);
        ResponseMotoDto responseMotoDto = new ResponseMotoDto(motoInterno.getId(), motoInterno.getModelo(), motoInterno.getTaxa(), motoInterno.getPrecoFinal());

        return responseMotoDto;
    }

    @Override
    public void deletar(String id) {
        Motocicleta motocicleta = repositorio.pegarPorId(id);
        repositorio.deletar(motocicleta);
    }

    @Override
    public void editar(MotocicletaDto motocicletaDto, String idAntigo) {
        Motocicleta motocicletaOld = repositorio.pegarPorId(idAntigo);
        Motocicleta motocicletaNew = new Motocicleta();
        motocicletaNew.setId(motocicletaOld.getId());
        motocicletaNew.setModelo(motocicletaDto.getModelo());
        motocicletaNew.setPreco(motocicletaDto.getPreco());
        motocicletaNew.setTaxa();
        motocicletaNew.setCalculoStrategy(StrategyFactory.selecionarCalculo(motocicletaDto.getMarca()));
        motocicletaNew.calcularPreco();
        repositorio.editar(motocicletaNew, motocicletaOld);
    }
}
