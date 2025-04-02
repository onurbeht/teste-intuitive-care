package com.desafio04.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio04.domain.entity.Operadoras;
import com.desafio04.domain.repository.OperadorasRepository;
import com.desafio04.dtos.OperadorasResponseDto;
import com.desafio04.dtos.PaginationResponseDto;

@Service
public class OperadorasService {

    private final OperadorasRepository operadorasRepository;

    public OperadorasService(OperadorasRepository operadorasRepository) {
        this.operadorasRepository = operadorasRepository;
    }

    public PaginationResponseDto getAll(Pageable pageable) {

        Page<OperadorasResponseDto> response = operadorasRepository.findAll(pageable).map(this::mapToDto);

        return new PaginationResponseDto(response.getContent(), response.getTotalPages(), response.getTotalElements(),
                response.getSize(), response.getNumber(), response.isFirst(), response.isLast());
    }

    private OperadorasResponseDto mapToDto(Operadoras operadora) {
        return new OperadorasResponseDto(operadora.getRegistro_ans(), operadora.getCnpj(), operadora.getRazao_social(),
                operadora.getNome_fantasia(), operadora.getModalidade(),
                operadora.getLogradouro(), operadora.getNumero(), operadora.getComplemento(), operadora.getBairro(),
                operadora.getCidade(), operadora.getUf(), operadora.getCep(),
                operadora.getDdd(), operadora.getTelefone(), operadora.getFax(), operadora.getEndereco_eletronico(),
                operadora.getRepresentante(), operadora.getCargo_representante(),
                operadora.getRegiao_de_comercializacao(), operadora.getData());
    }

    public OperadorasRepository getOperadorasRepository() {
        return operadorasRepository;
    }

}
