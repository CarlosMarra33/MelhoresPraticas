package com.example.tp3.infraLayer.repositorio;


import com.example.tp3.domainLayer.model.Motocicleta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MotocicletaRepositorio {
    private List<Motocicleta> motocicletas = new ArrayList(Arrays.asList(new Motocicleta("12","teste",2000.24,15.6, 3000.32)));

    public void save(Motocicleta motocicleta){
        motocicletas.add(motocicleta);
    }

    public List<Motocicleta> listarTodos(){
        return motocicletas;
    }

    public Motocicleta pegarPorId(String id){
        for(Motocicleta i : motocicletas){
                if (i.getId().equals(id)){
                    return i;
                }
        }
        return null;
    }

    public void editar(Motocicleta motocicletaNew,Motocicleta motocicletaOld){
        motocicletas.remove(motocicletaOld);
        motocicletas.add(motocicletaNew);
    }

    public void deletar(Motocicleta motocicleta){
        motocicletas.remove(motocicleta);
    }
}
