package com.desafio04.dtos;

import java.util.List;

public record PaginationResponseDto(
        List<OperadorasResponseDto> content,
        int totalPages,
        long totalElements,
        int size,
        int number,
        boolean first,
        boolean last) {

}
