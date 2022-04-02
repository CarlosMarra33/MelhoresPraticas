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
        Assert.assertEquals(15.6, motocicleta.getTaxa());
    }

    @Test
    public void buscartodos(){
        List<ResponseMotoDto> motoDtos = service.listarTodos();

        Assert.assertEquals(motoDtos.isEmpty(), motoDtos.isEmpty());
    }

    @Test
    public void salvar(){
        MotocicletaDto motoDto = new MotocicletaDto("teste",22.5,"honda","22");
        ResponseMotoDto responseMotoDto = new ResponseMotoDto();
        service.cadastrarMotoocicleta(motoDto);
        List<ResponseMotoDto> listaUsuarios = service.listarTodos();
        responseMotoDto = listaUsuarios.get(2);

        Assert.assertEquals(3, listaUsuarios.size());
        Assert.assertEquals(responseMotoDto.getId(), motoDto.getId());
        Assert.assertEquals(responseMotoDto.getModelo(), motoDto.getModelo());
    }

    @Test
    public void editar(){
        MotocicletaDto motoDto = new MotocicletaDto("teste2222222222",22.5,"honda","22");
        service.editar(motoDto, "1");

        Assert.assertEquals(motoDto.getModelo(), service.pegarUmPeloId("22").getModelo());
    }
}
