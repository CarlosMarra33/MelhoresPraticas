package com.example.tp3;

import com.example.tp3.domainLayer.service.MotocicletaService;
import com.example.tp3.presentationLayer.DTO.MotocicletaDto;
import com.example.tp3.presentationLayer.DTO.ResponseMotoDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class RepositorioTeste {

    @Autowired
    MotocicletaService service;

    @Test
    public void buscarPorId(){
        ResponseMotoDto motocicleta = service.pegarUmPeloId("12");

        Assert.assertEquals("teste", motocicleta.getModelo());
    }

    @Test
    public void buscartodos(){
        List<ResponseMotoDto> motoDtos = service.listarTodos();

        Assert.assertEquals(false, motoDtos.isEmpty());
    }

    @Test
    public void salvar(){
        MotocicletaDto motoDto = new MotocicletaDto("teste",22.5,"honda","22");

        service.cadastrarMotocicleta(motoDto);
        List<ResponseMotoDto> listaUsuarios = service.listarTodos();

        Assert.assertEquals(2, listaUsuarios.size());
    }

}
