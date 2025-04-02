package com.desafio04.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.desafio04.domain.entity.Operadoras;
import com.desafio04.domain.repository.OperadorasRepository;
import com.desafio04.dtos.OperadorasResponseDto;
import com.desafio04.dtos.PaginationResponseDto;

@ExtendWith(MockitoExtension.class)
public class OperadorasServiceTest {

    @Mock
    private OperadorasRepository operadorasRepository;

    @InjectMocks
    private OperadorasService operadorasService;

    @Test
    public void getAll_ShouldReturnPaginationResponseDto() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        List<Operadoras> operadorasList = new ArrayList<>();
        operadorasList.add(createOperadora());
        Page<Operadoras> operadorasPage = new PageImpl<>(operadorasList, pageable, operadorasList.size());

        when(operadorasRepository.findAll(any(Pageable.class))).thenReturn(operadorasPage);

        // Act
        PaginationResponseDto result = operadorasService.getAll(pageable);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.content().size());
        assertEquals(1, result.totalElements());
        assertEquals(1, result.totalPages());
        assertEquals(10, result.size());
        assertEquals(0, result.number());
        assertEquals(true, result.first());
        assertEquals(true, result.last());

        OperadorasResponseDto operadoraDto = result.content().get(0);
        assertEquals(123456, operadoraDto.registro_ans());
        assertEquals("12345678901234", operadoraDto.cnpj());
        assertEquals("Razao Social Teste", operadoraDto.razao_social());
        assertEquals("Nome Fantasia Teste", operadoraDto.nome_fantasia());
        assertEquals("Modalidade Teste", operadoraDto.modalidade());
        assertEquals("Logradouro Teste", operadoraDto.logradouro());
        assertEquals("123", operadoraDto.numero());
        assertEquals("Complemento Teste", operadoraDto.complemento());
        assertEquals("Bairro Teste", operadoraDto.bairro());
        assertEquals("Cidade Teste", operadoraDto.cidade());
        assertEquals("UF", operadoraDto.uf());
        assertEquals("12345678", operadoraDto.cep());
        assertEquals("11", operadoraDto.ddd());
        assertEquals("12345678", operadoraDto.telefone());
        assertEquals("98765432", operadoraDto.fax());
        assertEquals("email@teste.com", operadoraDto.endereco_eletronico());
        assertEquals("Representante Teste", operadoraDto.representante());
        assertEquals("Cargo Teste", operadoraDto.cargo_representante());
        assertEquals(1, operadoraDto.regiao_de_comercializacao());
        assertEquals(LocalDate.of(2023, 1, 1), operadoraDto.data());
    }

    private Operadoras createOperadora() {
        return Operadoras.builder()
                .registro_ans(123456)
                .cnpj("12345678901234")
                .razao_social("Razao Social Teste")
                .nome_fantasia("Nome Fantasia Teste")
                .modalidade("Modalidade Teste")
                .logradouro("Logradouro Teste")
                .numero("123")
                .complemento("Complemento Teste")
                .bairro("Bairro Teste")
                .cidade("Cidade Teste")
                .uf("UF")
                .cep("12345678")
                .ddd("11")
                .telefone("12345678")
                .fax("98765432")
                .endereco_eletronico("email@teste.com")
                .representante("Representante Teste")
                .cargo_representante("Cargo Teste")
                .regiao_de_comercializacao(1)
                .data(LocalDate.of(2023, 1, 1))
                .build();
    }

}
