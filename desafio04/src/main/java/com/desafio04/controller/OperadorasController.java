package com.desafio04.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio04.dtos.PaginationResponseDto;
import com.desafio04.service.OperadorasService;

@RestController
@RequestMapping("/operadoras")
public class OperadorasController {

    private final OperadorasService operadorasService;

    public OperadorasController(OperadorasService operadorasService) {
        this.operadorasService = operadorasService;
    }

    @GetMapping
    public ResponseEntity<PaginationResponseDto> getAll(@PageableDefault(size = 10, direction = Direction.DESC) Pageable pagination) {

        return ResponseEntity.ok(operadorasService.getAll(pagination));
    }

}
