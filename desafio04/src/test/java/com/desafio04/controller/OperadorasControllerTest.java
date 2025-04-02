package com.desafio04.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mapping.PropertyPath;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.data.util.ClassTypeInformation;
import org.springframework.data.util.TypeInformation;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.desafio04.domain.entity.Operadoras;
import com.desafio04.dtos.OperadorasResponseDto;
import com.desafio04.dtos.PaginationResponseDto;
import com.desafio04.service.OperadorasService;

@WebMvcTest(controllers = OperadorasController.class)
public class OperadorasControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    OperadorasService operadorasService;

    @Test
    void getAll_ShouldReturnOkAndPaginationResponseDto() throws Exception {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        List<OperadorasResponseDto> operadoras = new ArrayList<>();
        operadoras.add(new OperadorasResponseDto(123456, "12345678901234", "Razao Social", "Nome Fantasia", "Modalidade", "Logradouro", "123", "Complemento", "Bairro", "Cidade", "UF", "12345678", "11", "12345678", "12345678", "email@email.com", "Representante", "Cargo", 1, LocalDate.now()));
        Page<OperadorasResponseDto> page = new PageImpl<>(operadoras, pageable, 1);
        PaginationResponseDto expectedResponse = new PaginationResponseDto(page.getContent(), page.getTotalPages(), page.getTotalElements(), page.getSize(), page.getNumber(), page.isFirst(), page.isLast());

        Mockito.when(operadorasService.getAll(Mockito.any(Pageable.class))).thenReturn(expectedResponse);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/operadoras")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].registro_ans").value(123456))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPages").value(expectedResponse.totalPages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").value(expectedResponse.totalElements()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size").value(expectedResponse.size()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(expectedResponse.number()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.first").value(expectedResponse.first()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.last").value(expectedResponse.last()));
    }

    @Test
    void getAll_ShouldCallServiceWithCorrectPagination() throws Exception {
        // Arrange
        Pageable pageable = PageRequest.of(1, 5);
        List<OperadorasResponseDto> operadoras = new ArrayList<>();
        Page<OperadorasResponseDto> page = new PageImpl<>(operadoras, pageable, 0);
        PaginationResponseDto expectedResponse = new PaginationResponseDto(page.getContent(), page.getTotalPages(), page.getTotalElements(), page.getSize(), page.getNumber(), page.isFirst(), page.isLast());

        when(operadorasService.getAll(any(Pageable.class))).thenReturn(expectedResponse);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/operadoras?page=1&size=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Assert
        Mockito.verify(operadorasService, Mockito.times(1)).getAll(Mockito.argThat(p ->
                p.getPageNumber() == 1 && p.getPageSize() == 5
        ));
    }

    @Test
    void getAll_ShouldCallServiceWithDefaultPagination() throws Exception {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "data"));
        List<OperadorasResponseDto> operadoras = new ArrayList<>();
        Page<OperadorasResponseDto> page = new PageImpl<>(operadoras, pageable, 0);
        PaginationResponseDto expectedResponse = new PaginationResponseDto(page.getContent(), page.getTotalPages(), page.getTotalElements(), page.getSize(), page.getNumber(), page.isFirst(), page.isLast());

        Mockito.when(operadorasService.getAll(Mockito.any(Pageable.class))).thenReturn(expectedResponse);

        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/operadoras")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Assert
        Mockito.verify(operadorasService, Mockito.times(1)).getAll(Mockito.argThat(p ->
                p.getPageNumber() == 0 && p.getPageSize() == 10 && p.getSort().getOrderFor("data").isDescending()
        ));
    }

}
