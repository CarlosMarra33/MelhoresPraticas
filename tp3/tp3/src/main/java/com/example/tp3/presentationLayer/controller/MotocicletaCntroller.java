package com.example.tp3.presentationLayer.controller;

import com.example.tp3.domainLayer.model.Motocicleta;
import com.example.tp3.domainLayer.service.MotocicletaService;
import com.example.tp3.presentationLayer.DTO.MotocicletaDto;
import com.example.tp3.presentationLayer.DTO.ResponseMotoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotocicletaCntroller {

    @Autowired
    MotocicletaService motocicletaService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> criarUsuario(@RequestBody MotocicletaDto motoDto){
        try {
            motocicletaService.cadastrarMotoocicleta(motoDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarTodos(){

        try{
            List<ResponseMotoDto> motocicletas = motocicletaService.listarTodos();
            return ResponseEntity.ok(motocicletas);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<?> listarUSer(@RequestParam String id){
        try{
            ResponseMotoDto motocicleta = motocicletaService.pegarUmPeloId(id);
            return ResponseEntity.ok(motocicleta);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarMotocicleta(@RequestParam String id){
        try {
            motocicletaService.deletar(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editarUsuario")
    public ResponseEntity<?> editar(@RequestParam String idAntigo,
                                    @RequestParam String modelo,
                                    @RequestParam double preco,
                                    @RequestParam String marca,
                                    @RequestParam String id){
        MotocicletaDto motocicletaDto = new MotocicletaDto(modelo,preco,marca,id);
        try{
            motocicletaService.editar(motocicletaDto, idAntigo);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}
